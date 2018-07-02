package com.qianxun.admin.service;

import com.qianxun.admin.model.entity.SysRole;

import java.util.List;

public interface SysRoleService{
    boolean addSysRole(SysRole sysRole);

    boolean editSysRole(SysRole sysRole);

    List<SysRole> findAllSysRoles();

    SysRole getSysRole(int id);

    boolean deleteSysRole(int id);
}