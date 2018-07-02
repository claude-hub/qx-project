package com.qianxun.admin.service.impl;

import com.qianxun.admin.mapper.SysRoleMapper;
import com.qianxun.admin.model.entity.SysRole;
import com.qianxun.admin.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public boolean addSysRole(SysRole sysRole) {
        return this.sysRoleMapper.insert(sysRole) > 0;
    }

    @Override
    public boolean editSysRole(SysRole sysRole) {
        return sysRoleMapper.updateByPrimaryKey(sysRole) > 0;

    }

    @Override
    public List<SysRole> findAllSysRoles() {
        return sysRoleMapper.selectAll();
    }

    @Override
    public SysRole getSysRole(int id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteSysRole(int id) {
        return sysRoleMapper.deleteByPrimaryKey(id) > 0;
    }
}