package com.qianxun.service.impl;

import com.qianxun.entity.SysUser;
import com.qianxun.mapper.SysUserMapper;
import com.qianxun.service.ISysUserService;
import com.qianxun.service.exception.AuthenticateException;
import com.qianxun.service.exception.PasswordInvalid;
import com.qianxun.service.exception.UserNotFoundException;
import com.qianxun.utils.jwt.JwtTokenUtil;
import com.qianxun.utils.exception.InvalidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SysUserServiceImpl implements ISysUserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public SysUser getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        if (principal instanceof SysUser) {
            return (SysUser) principal;
        } else {
            return null;
        }
    }

    @Override
    public Boolean addSysUser(SysUser sysUser, String password) throws InvalidException {
        // 判断电话是否重复
        int columnStrExists = sysUserMapper.columnStrExists("phone", sysUser.getPhone());
        if (columnStrExists > 0) {
            throw new InvalidException("手机号已存在");
        }
        //登录次数0
        sysUser.setSignInCount(0);

        sysUser.setPasswordEncrypted(encryptPassword(password));
        return sysUserMapper.insert(sysUser) > 0;
    }

    private String encryptPassword(String password){
        return passwordEncoder.encode(password);
    }

    @Override
    public SysUser signIn(String loginStr, String password) throws AuthenticateException {
        SysUser user = sysUserMapper.selectByLoginStr(loginStr);
        if (user == null) {
            throw new UserNotFoundException("用户不存在");
        }
        if(!accountValid(user, password)){
            throw new PasswordInvalid("密码错误");
        }
        String token = jwtTokenUtil.generateToken(user.getId(),user.getPhone());
        sysUserMapper.updateCol(user.getId(), "current_token", token);
        user.setCurrentToken(token);
        return afterSignIn(user);
    }

    private SysUser afterSignIn(SysUser user) {
        sysUserMapper.increaseSignInCount(user.getId());
        sysUserMapper.updateSignInAt(user.getId());
        return user;
    }

    @Override
    public SysUser signIn(String token) {
        String userId = jwtTokenUtil.getPrivateClaimFromToken(token,"id");
        return sysUserMapper.selectByPrimaryKey(Integer.parseInt(userId));
    }

    /**
     * 密码验证
     * @param user
     * @param password
     * @return
     */
    private Boolean accountValid(SysUser user, String password) {
        return passwordEncoder.matches(password, user.getPasswordEncrypted());
    }
}