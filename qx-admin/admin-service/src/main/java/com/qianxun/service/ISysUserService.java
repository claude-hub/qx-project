package com.qianxun.service;

import com.qianxun.entity.SysUser;
import com.qianxun.utils.exception.InvalidException;

public interface ISysUserService {
    Boolean addSysUser(SysUser sysUser, String password) throws InvalidException;
}