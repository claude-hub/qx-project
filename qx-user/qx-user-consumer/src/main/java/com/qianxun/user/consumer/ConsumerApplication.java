package com.qianxun.user.consumer;

import com.qianxun.user.consumer.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author Cloudy
 * Date: 2019/4/27 16:22
 */

@SpringBootApplication
@EnableEurekaClient
public class ConsumerApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
