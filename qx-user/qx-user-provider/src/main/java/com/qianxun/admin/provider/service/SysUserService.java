package com.qianxun.admin.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qianxun.admin.api.dto.extend.SysUserDTO;
import com.qianxun.admin.api.dto.sysUser.request.SysUserQueryInputDTO;
import com.qianxun.admin.api.entity.SysUser;

/**
 * @author Cloudy
 *  */
public interface SysUserService extends IService<SysUser> {
    SysUserDTO getUserInfoByAccount(String account);

    /**
     * 账号密码登录
     * @param loginStr
     * @param password
     * @return
     */
    SysUserDTO signIn(String loginStr, String password);

    /**
     * 通过token登录
     *
     * @param token 令牌
     * @return 用户实体
     */
    SysUserDTO signIn(String token);

    /**
     * 分页查询用户信息（含有角色信息）
     *
     * @param page    分页对象
     * @param dto   参数列表
     * @return
     */
    IPage getUserWithRolePage(Page page, SysUserQueryInputDTO dto);
}
