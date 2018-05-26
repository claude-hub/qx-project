//package com.qianxun.service.config;
//
//import com.qianxun.service.ISysUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import org.springframework.stereotype.Component;
//
//@Component
//public class EcSecurityConfigurer {
//    @Autowired
//    private ISysUserService iSysUserService;
//
//    public HttpSecurity httpSecurityConfigure(HttpSecurity http){
//        return http.addFilterBefore(new HeaderTokenWebFilter(iSysUserService), BasicAuthenticationFilter.class)
//                .authenticationProvider(jwtAuthenticationProvider)
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                .antMatchers("/api/auth/sign_in").permitAll()
//                .antMatchers("/api/auth/users*/**").permitAll()//.hasAnyAuthority("SYSTEM:MANAGE")
//                .and();
//    }
//}
