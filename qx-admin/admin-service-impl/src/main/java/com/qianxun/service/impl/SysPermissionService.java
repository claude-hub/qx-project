package com.qianxun.service.impl;

import com.qianxun.entity.SysPermission;
import com.qianxun.mapper.SysPermissionMapper;
import com.qianxun.service.ISysPermissionService;
import com.qianxun.utils.spring.SpringContextHolderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPermissionService implements ISysPermissionService {
    @Autowired
    private SysPermissionMapper permissionMapper;

    //用静态方法的方式获取spring容器中的bean
    public static ISysPermissionService me() {
        return SpringContextHolderUtil.getBean(ISysPermissionService.class);
    }

    @Override
    public List<SysPermission> getPermissionsByUserId(Integer id) {
        return permissionMapper.findPermissionsByUserId(id);
    }
}
