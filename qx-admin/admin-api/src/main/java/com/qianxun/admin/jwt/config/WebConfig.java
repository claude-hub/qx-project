package com.qianxun.admin.jwt.config;

import com.qianxun.admin.jwt.filter.AuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
    @Bean
    public AuthFilter jwtAuthenticationTokenFilter() {
        return new AuthFilter();
    }
}
