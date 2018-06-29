package com.qianxun.admin.service;

import com.qianxun.admin.entity.SysMenu;

import java.util.List;

public interface SysMenuService{
    boolean addSysMenu(SysMenu sysMenu);

    boolean editSysMenu(SysMenu sysMenu);

    List<SysMenu> findAllSysMenus();

    SysMenu getSysMenu(int id);

    boolean deleteSysMenu(int id);
}