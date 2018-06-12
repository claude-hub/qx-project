package com.qianxun.admin.service.impl;

import com.qianxun.admin.dao.SysPermissionMapper;
import com.qianxun.admin.entity.SysPermission;
import com.qianxun.admin.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public boolean addSysPermission(SysPermission sysPermission) {
        return this.sysPermissionMapper.insert(sysPermission) > 0;
    }

    @Override
    public boolean editSysPermission(SysPermission sysPermission) {
        return sysPermissionMapper.updateByPrimaryKey(sysPermission) > 0;

    }

    @Override
    public List<SysPermission> findAllSysPermissions() {
        return sysPermissionMapper.selectAll();
    }

    @Override
    public SysPermission getSysPermission(int id) {
        return sysPermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteSysPermission(int id) {
        return sysPermissionMapper.deleteByPrimaryKey(id) > 0;
    }
}