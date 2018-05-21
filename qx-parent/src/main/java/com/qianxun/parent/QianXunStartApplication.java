package com.qianxun.parent;

import com.qianxun.flyway.FlyWayConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Import({FlyWayConfig.class})
@SpringBootApplication
@ComponentScan(basePackages = "com.qianxun")//包名
public class QianXunStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(QianXunStartApplication.class, args);
	}
}
