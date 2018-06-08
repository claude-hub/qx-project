package com.qianxun.admin.service.impl;

import com.qianxun.admin.dao.SysUserMapper;
import com.qianxun.admin.entity.SysUser;
import com.qianxun.admin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public boolean addSysUser(SysUser sysUser, String password) {
        sysUser.setPasswordEncrypted(password);
        return this.sysUserMapper.insert(sysUser) > 0;
    }

    @Override
    public boolean editSysUser(SysUser sysUser) {
        return sysUserMapper.updateByPrimaryKey(sysUser) > 0;

    }

    @Override
    public List<SysUser> findAllSysUsers() {
        return sysUserMapper.selectAll();
    }

    @Override
    public SysUser getSysUser(int id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteSysUser(int id) {
        return sysUserMapper.deleteByPrimaryKey(id) > 0;
    }
}