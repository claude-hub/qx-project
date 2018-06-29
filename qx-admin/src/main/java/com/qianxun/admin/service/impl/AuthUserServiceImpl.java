package com.qianxun.admin.service.impl;

import com.qianxun.admin.dao.AuthUserMapper;
import com.qianxun.admin.entity.SysMenu;
import com.qianxun.admin.entity.SysUser;
import com.qianxun.admin.exception.AuthenticateException;
import com.qianxun.admin.exception.PasswordInvalid;
import com.qianxun.admin.exception.UserNotFoundException;
import com.qianxun.admin.service.AuthUserService;
import com.qianxun.common.utils.jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthUserServiceImpl implements AuthUserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthUserMapper authUserMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    /**
     * 获取当前用户
     * @return
     */
    @Override
    public SysUser getUser(){
        //获取spring security认证的用户
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        if (principal instanceof SysUser) {
            return (SysUser) principal;
        } else {
            return null;
        }
    }
    /**
     * 账号密码登录
     * @param loginStr
     * @param password
     * @return
     * @throws AuthenticateException
     */
    @Override
    public SysUser signIn(String loginStr, String password) throws AuthenticateException {
        SysUser user = authUserMapper.selectByLoginStr(loginStr);
        if (user == null) {
            throw new UserNotFoundException("用户不存在");
        }
        if(!accountValid(user, password)){
            throw new PasswordInvalid("密码错误");
        }
        String token = jwtTokenUtil.generateToken(user.getUserId(),user.getPhone());
        authUserMapper.updateCol(user.getUserId(), "current_token", token);
        user.setCurrentToken(token);
        return afterSignIn(user);
    }

    /**
     * 登录成功后
     * @param user
     * @return
     */
    private SysUser afterSignIn(SysUser user) {
        authUserMapper.increaseSignInCount(user.getUserId());
        authUserMapper.updateSignInAt(user.getUserId());
        return user;
    }

    /**
     * 通过token登录
     * @param token 令牌
     * @return
     */
    @Override
    public SysUser signIn(String token) {
        String userId = jwtTokenUtil.getPrivateClaimFromToken(token,"user_id");
        SysUser user = authUserMapper.selectByPrimaryKey(Integer.parseInt(userId));
        if (!user.getCurrentToken().equals(token)) {
            return null;
        }
        return user;
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

    @Override
    public List<SysMenu> getMenusByUserId(Integer id) {
        return authUserMapper.findMenusByUserId(id);
    }
}
