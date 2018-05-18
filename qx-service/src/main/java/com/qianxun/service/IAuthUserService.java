package com.qianxun.service;

import com.qianxun.entity.AuthUser;

public interface IAuthUserService {
    AuthUser singIn(String loginStr, String password);

    Boolean addAuthUser(AuthUser authUser,String password);
}