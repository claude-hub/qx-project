package com.qianxun.service.impl;

import com.qianxun.dao.mapper.AuthUserMapper;
import com.qianxun.entity.AuthUser;
import com.qianxun.service.IAuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthUserServiceImpl implements IAuthUserService {
    private final AuthUserMapper authUserMapper;

    @Autowired
    public AuthUserServiceImpl(AuthUserMapper authUserMapper) {
        this.authUserMapper = authUserMapper;
    }


    @Override
    public AuthUser singIn(String loginStr, String password){
        return new AuthUser();
    }

    @Override
    public Boolean addAuthUser(AuthUser authUser, String password){
        return false;
    }

}
