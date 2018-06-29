package com.qianxun.admin.service.impl;

import com.qianxun.admin.dao.SysUserMapper;
import com.qianxun.admin.entity.SysUser;
import com.qianxun.admin.service.SysUserService;
import com.qianxun.common.utils.exception.InvalidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean addSysUser(SysUser sysUser, String password) throws InvalidException {
        // 判断电话是否重复
        int columnStrExists = sysUserMapper.columnStrExists("phone", sysUser.getPhone());
        if (columnStrExists > 0) {
            throw new InvalidException("手机号已存在");
        }
        sysUser.setPasswordEncrypted(encryptPassword(password));
        return this.sysUserMapper.insert(sysUser) > 0;
    }
    private String encryptPassword(String password){
        return passwordEncoder.encode(password);
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