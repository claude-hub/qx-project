package com.qianxun.user.consumer.utils;

import com.qianxun.admin.api.dto.extend.SysUserDTO;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Cloudy
 * Date: 2019/5/27 23:30
 */
@UtilityClass
public class SecurityBeanUtils {
    public SysUserDTO getUser(){
        //获取spring security认证的用户
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        if (principal instanceof SysUserDTO) {
            return (SysUserDTO) principal;
        } else {
            return null;
        }
    }
}
