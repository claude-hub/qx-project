package com.qianxun.admin;

import com.qianxun.common.security.annotation.EnableQxFeignClients;
import com.qianxun.common.security.annotation.EnableQxResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 用户统一管理系统
 */
@EnableQxResourceServer
@EnableQxFeignClients
@SpringCloudApplication
public class AdminApplication {
	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

}
