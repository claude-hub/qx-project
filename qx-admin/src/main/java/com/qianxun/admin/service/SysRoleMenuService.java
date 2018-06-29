package com.qianxun.admin.service;

import com.qianxun.admin.entity.SysRoleMenu;

import java.util.List;

public interface SysRoleMenuService{
    boolean addSysRoleMenu(SysRoleMenu sysRoleMenu);

    boolean editSysRoleMenu(SysRoleMenu sysRoleMenu);

    List<SysRoleMenu> findAllSysRoleMenus();

    SysRoleMenu getSysRoleMenu(int id);

    boolean deleteSysRoleMenu(int id);
}