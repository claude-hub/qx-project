package com.qianxun.config;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * author: Claude
 * email: 314705487@qq.com
 * create date: 04/25/19 16:29
 */
@EnableConfigServer
@SpringCloudApplication
public class ConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }
}
