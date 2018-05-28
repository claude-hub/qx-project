package com.qianxun.service.config;

import com.qianxun.service.ISysUserService;
import com.qianxun.service.jwt.JWTAuthenticationProvider;
import com.qianxun.service.jwt.filter.AuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * spring security配置
 */
@Component
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private JWTAuthenticationProvider provider;

    @Autowired
    private ISysUserService iSysUserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(new AuthFilter(iSysUserService),BasicAuthenticationFilter.class)
                .authenticationProvider(provider)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("**").permitAll()
                .anyRequest().fullyAuthenticated()
                .and().csrf().disable();
    }
}