package com.qianxun.admin.service;

import com.qianxun.admin.entity.SysUserRole;

import java.util.List;

public interface SysUserRoleService{
    boolean addSysUserRole(SysUserRole sysUserRole);

    boolean editSysUserRole(SysUserRole sysUserRole);

    List<SysUserRole> findAllSysUserRoles();

    SysUserRole getSysUserRole(int id);

    boolean deleteSysUserRole(int id);
}