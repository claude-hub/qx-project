package com.qianxun.service;

import com.qianxun.entity.AuthUser;

public interface  AuthUserService {
    AuthUser singIn(String loginStr, String password);
}