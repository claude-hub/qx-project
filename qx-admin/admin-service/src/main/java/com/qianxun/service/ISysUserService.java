package com.qianxun.service;

import com.qianxun.entity.SysUser;

public interface ISysUserService {
    Boolean addSysUser(SysUser sysUser, String password);
}