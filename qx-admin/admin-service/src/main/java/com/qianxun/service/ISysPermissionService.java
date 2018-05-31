package com.qianxun.service;

import com.qianxun.entity.SysPermission;
import com.qianxun.utils.spring.SpringContextHolderUtil;

import java.util.List;

public interface ISysPermissionService {
    /**
     * 通过用户id，获取用户权限集
     * @param id
     * @return
     */
    List<SysPermission> getPermissionsByUserId(Integer id);

    //用静态方法的方式获取spring容器中的bean
    static ISysPermissionService me() {
        return SpringContextHolderUtil.getBean(ISysPermissionService.class);
    }
}
