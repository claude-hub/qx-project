package com.qianxun.service.impl;

import com.qianxun.entity.SysUser;
import com.qianxun.mapper.SysUserMapper;
import com.qianxun.service.ISysUserService;
import com.qianxun.utils.exception.InvalidException;
import com.qianxun.utils.shiro.ShiroKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SysUserServiceImpl implements ISysUserService {
    private final SysUserMapper sysUserMapper;

    @Autowired
    public SysUserServiceImpl(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    @Override
    public Boolean addSysUser(SysUser sysUser, String password) throws InvalidException {
        // 判断电话是否重复
        int columnStrExists = sysUserMapper.columnStrExists("phone",sysUser.getPhone());
        if (columnStrExists > 0) {
            throw new InvalidException("手机号已存在");
        }
        // 完善账号信息
        String salt = ShiroKit.getRandomSalt(5);
        sysUser.setPasswordSalt(salt);
        String passwordEncrypted = ShiroKit.md5(password, salt);
        sysUser.setPasswordEncrypted(passwordEncrypted);

        return  sysUserMapper.insert(sysUser) > 0;
    }
}
