package com.qianxun.admin.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
public class UserProviderApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserProviderApplication.class, args);
	}
}
