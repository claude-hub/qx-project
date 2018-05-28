package com.qianxun.admin.controller;

import com.qianxun.entity.SysUser;
import com.qianxun.service.ISysUserService;
import com.qianxun.utils.controller.ApiController;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController extends ApiController{
    @Autowired
    private ISysUserService userService;

    protected SysUser getCurrentUser() {
        return userService.getUser();
    }
}
