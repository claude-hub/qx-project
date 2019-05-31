package com.qianxun.admin.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qianxun.admin.api.entity.SysMenu;

import java.util.List;

/**
 * @author Cloudy
 *  */
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenu> getMenusByRoleId(Integer roleId);

    List<SysMenu> getMenusByUserId(Integer userId);
}
