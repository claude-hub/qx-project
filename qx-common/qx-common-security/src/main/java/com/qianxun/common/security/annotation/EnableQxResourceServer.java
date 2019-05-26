package com.qianxun.common.security.annotation;

import com.qianxun.common.security.component.ResourceServerAuto;
import com.qianxun.common.security.component.SecurityBeanDefinition;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.*;

/**
 * 资源服务注解
 */
@Documented
@Inherited
@EnableResourceServer
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({ResourceServerAuto.class, SecurityBeanDefinition.class})
public @interface EnableQxResourceServer {

}
