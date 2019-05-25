package com.qianxun.sso.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@Order(1)
@AllArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true) //支持权限注解 @PreAuthorize("hasAnyRole('ROLE_USER')")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;

    /**
     * 让Security 忽略这些url，不做拦截处理
     *
     * @param
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers
                (
                        "/js/common.js",
                        "/js/jquery.min.js",
                        "/css/common.css",
                        "/css/font-awesome.min.css",
                        "/css/reset.css",
                        "/css/style.css",
                        "/images/banner.png",
                        "/images/cut.jpg",
                        "/images/logo_bg.jpg",
                        "/images/logowz.png",
                        "/fonts/fontawesome-webfont.woff2"
                );
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.requestMatchers()
//                .antMatchers("/login", "/oauth/authorize")
//                .and()
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .permitAll()
//                .and().csrf().disable();

//        http.requestMatchers()
//                .antMatchers("/login",
//                        "/oauth/authorize",
//                        "/authentication/form",
//                        "/tiger-login.html")
//                .and()
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/tiger-login.html")
//                .loginProcessingUrl("/authentication/form")
//                .permitAll()
//                .and().csrf().disable();

        http
                .requestMatchers()
                .antMatchers(
                        "/authentication/require",
                        "/login",
                        "/authentication/form", //放开登录方法
                        "/oauth/authorize")
                .and()
                .authorizeRequests()
                // 自定义页面或处理url,如果不配置全局允许，浏览器会提示服务器将页面转发多次
                .antMatchers(
                        "/authentication/require"
                )
                .permitAll()
                .anyRequest()
                .authenticated();
        http
                .formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .defaultSuccessUrl("http://localhost:8080")
                .and()
                .csrf()
                .disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}
