package com.qianxun.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // 配置注解
@PropertySource(value = "classpath:mybatis-config.yml")
@MapperScan("com.qianxun.dao.mapper")
public class DaoConfiguration {
}
