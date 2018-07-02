package com.qianxun.admin.service.impl;

import com.qianxun.admin.mapper.SysMenuMapper;
import com.qianxun.admin.model.entity.SysMenu;
import com.qianxun.admin.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public boolean addSysMenu(SysMenu sysMenu) {
        return this.sysMenuMapper.insert(sysMenu) > 0;
    }

    @Override
    public boolean editSysMenu(SysMenu sysMenu) {
        return sysMenuMapper.updateByPrimaryKey(sysMenu) > 0;

    }

    @Override
    public List<SysMenu> findAllSysMenus() {
        return sysMenuMapper.selectAll();
    }

    @Override
    public SysMenu getSysMenu(int id) {
        return sysMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteSysMenu(int id) {
        return sysMenuMapper.deleteByPrimaryKey(id) > 0;
    }
}