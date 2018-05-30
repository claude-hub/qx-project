package com.qianxun.service;

import com.qianxun.entity.SysPermission;

import java.util.List;

public interface ISysPermissionService {
    /**
     * 通过用户id，获取用户权限
     * @param id
     * @return
     */
    List<SysPermission> getPermissionsByUserId(Integer id);
}
