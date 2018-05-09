package com.qianxun.controller;

import com.qianxun.entity.User;

public class BaseController{

    protected User getCurrentUser() {
        User user = new User();
        user.setId(10);
        user.setName("test");
        return user;
    }
}
