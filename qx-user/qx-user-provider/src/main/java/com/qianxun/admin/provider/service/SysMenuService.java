package com.qianxun.admin.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qianxun.admin.api.entity.SysMenu;

import java.util.List;

/**
 * @author Cloudy
 *  */
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenu> getMenusByRoleId(Integer roleId);

    /**
     * 获取用户单独的权限
     * @param userId
     * @return
     */
    List<SysMenu> getMenusByUserId(Integer userId);

    /**
     * 获取当前用户所有权限(角色+自己)
     * @param userId
     * @return
     */
    List<SysMenu> getUserMenus(Integer userId);
}
