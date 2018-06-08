package com.qianxun.admin.service;

import com.qianxun.admin.entity.SysUser;

import java.util.List;

public interface SysUserService {
    boolean addSysUser(SysUser sysUser, String password);

    boolean editSysUser(SysUser sysUser);

    List<SysUser> findAllSysUsers();

    SysUser getSysUser(int id);

    boolean deleteSysUser(int id);
}