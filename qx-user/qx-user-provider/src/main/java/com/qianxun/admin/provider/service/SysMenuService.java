package com.qianxun.admin.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qianxun.admin.api.dto.extend.SysMenuDTO;
import com.qianxun.admin.api.dto.sysMenu.request.SysMenuQueryInputDTO;
import com.qianxun.admin.api.entity.SysMenu;

/**
 * @author Cloudy
 * Date 2019-05-13 14:37:45
 */
public interface SysMenuService extends IService<SysMenu> {

    Boolean saveSysMenu(SysMenuDTO sysMenuDTO);

    IPage getSysMenus(Page page, SysMenuQueryInputDTO inputDTO);

    Boolean updateSysMenu(SysMenuDTO sysMenuDTO);
}
