package com.qianxun.service;

import com.qianxun.entity.SysUser;
import com.qianxun.service.exception.AuthenticateException;
import com.qianxun.utils.exception.InvalidException;
import com.qianxun.utils.spring.SpringContextHolderUtil;

public interface ISysUserService {
    //用静态方法的方式获取spring容器中的bean
    static ISysUserService me() {
        return SpringContextHolderUtil.getBean(ISysUserService.class);
    }

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