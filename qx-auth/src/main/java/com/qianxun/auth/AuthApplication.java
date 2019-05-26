package com.qianxun.auth;

import com.qianxun.common.security.annotation.EnableQxFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 认证授权中心
 */
@SpringCloudApplication
@EnableQxFeignClients
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}
}
