package com.qianxun;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // 配置注解
@PropertySource("classpath:com/qianxun/application.yml")
@ComponentScan
@AutoConfigureBefore({FlywayAutoConfiguration.class})
@ImportAutoConfiguration({FlywayAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class Config {

}
