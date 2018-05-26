package com.qianxun.service.impl;

import com.qianxun.entity.SysUser;
import com.qianxun.mapper.SysUserMapper;
import com.qianxun.service.ISysUserService;
import com.qianxun.service.exception.AuthenticateException;
import com.qianxun.service.exception.UserNotFoundException;
import com.qianxun.utils.exception.InvalidException;
import com.qianxun.utils.shiro.ShiroKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SysUserServiceImpl implements ISysUserService {
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public Boolean addSysUser(SysUser sysUser, String password) throws InvalidException {
        // 判断电话是否重复
        int columnStrExists = sysUserMapper.columnStrExists("phone", sysUser.getPhone());
        if (columnStrExists > 0) {
            throw new InvalidException("手机号已存在");
        }
        // 完善账号信息
        String salt = ShiroKit.getRandomSalt(5);
        sysUser.setPasswordSalt(salt);
        //shiro加密
        String passwordEncrypted = ShiroKit.md5(password, salt);
        sysUser.setPasswordEncrypted(passwordEncrypted);
        //spring security加密
//        sysUser.setPasswordEncrypted(encryptPassword(password));
        return sysUserMapper.insert(sysUser) > 0;
    }

//    private String encryptPassword(String password){
//        return passwordEncoder.encode(password);
//    }

    @Override
    public SysUser signIn(String loginStr, String password) throws AuthenticateException {
        SysUser user = sysUserMapper.selectByLoginStr(loginStr);
        if (user == null) {
            throw new UserNotFoundException("用户不存在");
        }
//        if(!accountValid(user, password)){
//            throw new PasswordInvalid("密码错误");
//        }
        return user;
    }

    @Override
    public SysUser signIn(String token) {
        return null;
    }

    /**
     * 密码验证
     * @param user
     * @param password
     * @return
     */
//    private Boolean accountValid(SysUser user, String password) {
//        return passwordEncoder.matches(password, user.getPasswordEncrypted());
//    }
}