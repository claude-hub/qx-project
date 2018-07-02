package com.qianxun.admin.service.impl;

import com.qianxun.admin.mapper.SysUserRoleMapper;
import com.qianxun.admin.model.entity.SysUserRole;
import com.qianxun.admin.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public boolean addSysUserRole(SysUserRole sysUserRole) {
        return this.sysUserRoleMapper.insert(sysUserRole) > 0;
    }

    @Override
    public boolean editSysUserRole(SysUserRole sysUserRole) {
        return sysUserRoleMapper.updateByPrimaryKey(sysUserRole) > 0;

    }

    @Override
    public List<SysUserRole> findAllSysUserRoles() {
        return sysUserRoleMapper.selectAll();
    }

    @Override
    public SysUserRole getSysUserRole(int id) {
        return sysUserRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteSysUserRole(int id) {
        return sysUserRoleMapper.deleteByPrimaryKey(id) > 0;
    }
}