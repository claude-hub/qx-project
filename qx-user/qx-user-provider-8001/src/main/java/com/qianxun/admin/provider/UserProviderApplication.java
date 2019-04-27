package com.qianxun.admin.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient //服务发现
@ComponentScan(basePackages = "com.qianxun") //swagger
//扫描bean
@MapperScan("com.qianxun.admin.provider.mapper")
public class UserProviderApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserProviderApplication.class, args);
	}
}
