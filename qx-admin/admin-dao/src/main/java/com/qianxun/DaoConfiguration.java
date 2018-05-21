package com.qianxun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // 配置注解
@PropertySource(value = "classpath:application.properties")
@MapperScan("com.qianxun.mapper")
public class DaoConfiguration {
}