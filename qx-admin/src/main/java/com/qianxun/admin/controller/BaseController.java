package com.qianxun.admin.controller;

import com.qianxun.admin.model.entity.SysUser;
import com.qianxun.admin.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController{
    @Autowired
    private AuthUserService authUserService;

    protected SysUser getCurrentUser() {
        return authUserService.getUser();
    }
}
