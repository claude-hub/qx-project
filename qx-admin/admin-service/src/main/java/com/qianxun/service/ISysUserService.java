package com.qianxun.service;

import com.qianxun.entity.SysUser;
import com.qianxun.service.exception.AuthenticateException;
import com.qianxun.utils.exception.InvalidException;

public interface ISysUserService {
    Boolean addSysUser(SysUser sysUser, String password) throws InvalidException;

    SysUser signIn(String loginStr, String password) throws AuthenticateException;

    /**
     * 通过token登录
     *
     * @param token 令牌
     * @return 用户实体
     */
    SysUser signIn(String token);

    SysUser getUser();
}