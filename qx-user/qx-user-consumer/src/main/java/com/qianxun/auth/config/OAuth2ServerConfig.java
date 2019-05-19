package com.qianxun.auth.config;

import com.qianxun.auth.component.CustomTokenEnhancer;
import com.qianxun.auth.component.FilterIgnoreProperties;
import com.qianxun.auth.constant.SecurityConstants;
import com.qianxun.auth.service.ClientDetailsService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;

/**
 * @author Cloudy
 * Date: 2019/5/5 16:01
 * 认证服务器配置
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) //支持权限注解 @PreAuthorize("hasAnyRole('ROLE_USER')")
public class OAuth2ServerConfig {
    @Configuration
    @EnableResourceServer
    @AllArgsConstructor  //替代@Autowired构造注入
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
        private final FilterIgnoreProperties filterIgnoreProperties;
        @Override
        @SneakyThrows
        public void configure(HttpSecurity httpSecurity) {
            //允许使用iframe 嵌套，避免swagger-ui 不被加载的问题
            httpSecurity.headers().frameOptions().disable();
            ExpressionUrlAuthorizationConfigurer<HttpSecurity>
                    .ExpressionInterceptUrlRegistry registry = httpSecurity
                    .authorizeRequests();
            filterIgnoreProperties.getUrls()
                    .forEach(url -> registry.antMatchers(url).permitAll()); //不验证配置文件放行的url
            registry.anyRequest().authenticated() //验证所有url
                    .and().csrf().disable();
        }
    }

    @Configuration
    @EnableAuthorizationServer
    @AllArgsConstructor  //替代@Autowired构造注入
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

        private final AuthenticationManager authenticationManager;
        private final RedisConnectionFactory redisConnectionFactory;
        private final DataSource dataSource;
        private final UserDetailsService userDetailsService;

        @Override
        @SneakyThrows
        public void configure(ClientDetailsServiceConfigurer clients) {
            ClientDetailsService clientDetailsService = new ClientDetailsService(dataSource);
            clientDetailsService.setSelectClientDetailsSql(SecurityConstants.DEFAULT_SELECT_STATEMENT);
            clientDetailsService.setFindClientDetailsSql(SecurityConstants.DEFAULT_FIND_STATEMENT);
            clients.withClientDetails(clientDetailsService);
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
            endpoints.authenticationManager(authenticationManager);
            endpoints.tokenStore(tokenStore());
            endpoints.userDetailsService(userDetailsService);
            endpoints.tokenEnhancer(tokenEnhancer());
            endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
            //配置TokenServices参数
            DefaultTokenServices tokenServices = new DefaultTokenServices();
            tokenServices.setTokenStore(endpoints.getTokenStore());
            tokenServices.setSupportRefreshToken(true);
            tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
            tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
            tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(1)); // 1天
            endpoints.tokenServices(tokenServices);
        }

        @Override
        public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
            oauthServer
                    //允许表单认证
                    .allowFormAuthenticationForClients()
                    .checkTokenAccess("permitAll()");
        }

        @Bean
        public TokenStore tokenStore() {
            RedisTokenStore tokenStore = new RedisTokenStore(redisConnectionFactory);
            tokenStore.setPrefix(SecurityConstants.PROJECT_PREFIX + SecurityConstants.OAUTH_PREFIX);
            return tokenStore;
        }

        /**
         * 个性化Token，对密码模式(支持刷新token)有效，客户端模式(不支持token刷新)无效
         * @return
         */
        @Bean
        public TokenEnhancer tokenEnhancer() {
            return new CustomTokenEnhancer();
        }
    }

}
