package com.qianxun.admin.controller;

import com.qianxun.entity.SysUser;
import com.qianxun.utils.controller.ApiController;

public class BaseController extends ApiController{
    protected SysUser getCurrentUser() {
        SysUser user = new SysUser();
        user.setId(10);
        user.setName("test");
        return user;
    }
}
