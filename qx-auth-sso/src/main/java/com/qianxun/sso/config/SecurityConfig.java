package com.qianxun.sso.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@Order(1)
@AllArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true) //支持权限注解 @PreAuthorize("hasAnyRole('ROLE_USER')")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers()
                .antMatchers("/login", "/oauth/authorize")
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and().csrf().disable();

//        http
//                .formLogin().loginPage("/authentication/require")
//                .loginProcessingUrl("/authentication/form")
//                .and()
//                .authorizeRequests()
//                .antMatchers(
//                        "/login",
//                        "/authentication/require",
//                        "/authentication/form",
//                        "/oauth/authorize",
//                        "/js/common.js",
//                        "/js/jquery.min.js",
//                        "/css/common.css",
//                        "/css/font-awesome.min.css",
//                        "/css/reset.css",
//                        "/css/style.css",
//                        "/images/banner.png",
//                        "/images/cut.jpg",
//                        "/images/logo_bg.jpg",
//                        "/images/logowz.png",
//                        "/fonts/fontawesome-webfont.woff2"
//                )
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}
