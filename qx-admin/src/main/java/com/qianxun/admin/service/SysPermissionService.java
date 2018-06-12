package com.qianxun.admin.service;

import com.qianxun.admin.entity.SysPermission;

import java.util.List;

public interface SysPermissionService{
    boolean addSysPermission(SysPermission sysPermission);

    boolean editSysPermission(SysPermission sysPermission);

    List<SysPermission> findAllSysPermissions();

    SysPermission getSysPermission(int id);

    boolean deleteSysPermission(int id);
}