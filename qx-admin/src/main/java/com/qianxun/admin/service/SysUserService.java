package com.qianxun.admin.service;

import com.qianxun.admin.model.entity.SysUser;
import com.qianxun.common.utils.exception.InvalidException;

import java.util.List;

public interface SysUserService {
    boolean addSysUser(SysUser sysUser, String password) throws InvalidException;

    boolean editSysUser(SysUser sysUser);

    List<SysUser> findAllSysUsers();

    SysUser getSysUser(int id);

    boolean deleteSysUser(int id);
}