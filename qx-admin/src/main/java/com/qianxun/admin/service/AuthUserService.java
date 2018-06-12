package com.qianxun.admin.service;

import com.qianxun.admin.entity.SysPermission;
import com.qianxun.admin.entity.SysUser;
import com.qianxun.admin.exception.AuthenticateException;
import com.qianxun.common.utils.spring.SpringContextHolderUtil;

import java.util.List;

public interface AuthUserService {
    //用静态方法的方式获取spring容器中的bean
    static AuthUserService me() {
        return SpringContextHolderUtil.getBean(AuthUserService.class);
    }
    /**
     * 通过账号密码登录
     * @param loginStr
     * @param password
     * @return
     * @throws AuthenticateException
     */
    SysUser signIn(String loginStr, String password) throws AuthenticateException;

    /**
     * 通过token登录
     *
     * @param token 令牌
     * @return 用户实体
     */
    SysUser signIn(String token);

    /**
     * 获取当前用户
     * @return
     */
    SysUser getUser();

    /**
     * 通过用户id，获取用户权限集
     * @param id
     * @return
     */
    List<SysPermission> getPermissionsByUserId(Integer id);
}
