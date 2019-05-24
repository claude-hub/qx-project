//package com.qianxun.user.consumer.config;
//
//import com.qianxun.common.utils.security.FilterIgnoreProperties;
//import lombok.AllArgsConstructor;
//import lombok.SneakyThrows;
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//
///**
// * @author Cloudy
// * Date: 2019/5/24 0:32
// */
//@Configuration
//@EnableResourceServer
//@AllArgsConstructor  //替代@Autowired构造注入
//@EnableOAuth2Sso
//public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
//    private final FilterIgnoreProperties filterIgnoreProperties;
//
//    @Override
//    @SneakyThrows
//    public void configure(HttpSecurity httpSecurity) {
//        //允许使用iframe 嵌套，避免swagger-ui 不被加载的问题
//        httpSecurity.headers().frameOptions().disable();
//        ExpressionUrlAuthorizationConfigurer<HttpSecurity>
//                .ExpressionInterceptUrlRegistry registry = httpSecurity
//                .authorizeRequests();
//        filterIgnoreProperties.getUrls()
//                .forEach(url -> registry.antMatchers(url).permitAll()); //不验证配置文件放行的url
//        registry.anyRequest().authenticated() //验证所有url
//                .and().csrf().disable();
//    }
//}
package com.qianxun.user.consumer.config;


import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableOAuth2Sso
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) //支持权限注解 @PreAuthorize("hasAnyRole('ROLE_USER')")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login")
                .permitAll()
                .anyRequest()
                .authenticated();
    }

}
