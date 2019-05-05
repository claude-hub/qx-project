package com.qianxun.auth;

import com.qianxun.auth.component.FilterIgnoreProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author Cloudy
 * Date: 2019/4/28 16:47
 * EnableConfigurationProperties注解是去掉@ConfigurationProperties注解
 * 报错Not registered via @EnableConfigurationProperties or marked as Spring component
 */
@SpringBootApplication
@EnableConfigurationProperties({FilterIgnoreProperties.class})
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}
