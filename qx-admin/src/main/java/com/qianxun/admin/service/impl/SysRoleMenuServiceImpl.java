package com.qianxun.admin.service.impl;

import com.qianxun.admin.mapper.SysRoleMenuMapper;
import com.qianxun.admin.model.entity.SysRoleMenu;
import com.qianxun.admin.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public boolean addSysRoleMenu(SysRoleMenu sysRoleMenu) {
        return this.sysRoleMenuMapper.insert(sysRoleMenu) > 0;
    }

    @Override
    public boolean editSysRoleMenu(SysRoleMenu sysRoleMenu) {
        return sysRoleMenuMapper.updateByPrimaryKey(sysRoleMenu) > 0;

    }

    @Override
    public List<SysRoleMenu> findAllSysRoleMenus() {
        return sysRoleMenuMapper.selectAll();
    }

    @Override
    public SysRoleMenu getSysRoleMenu(int id) {
        return sysRoleMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteSysRoleMenu(int id) {
        return sysRoleMenuMapper.deleteByPrimaryKey(id) > 0;
    }
}