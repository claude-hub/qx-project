package com.qianxun.controller.web;

import com.qianxun.dto.UserLoginInputDTO;
import com.qianxun.entity.AuthUser;
import com.qianxun.service.IAuthUserService;
import com.qianxun.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

public class AuthController {
    private final IAuthUserService iAuthUserService;

    @Autowired
    public AuthController(IAuthUserService iAuthUserService){
        this.iAuthUserService = iAuthUserService;
    }

    @PostMapping("/sing_in")
    public JSONResult singIn(UserLoginInputDTO input){
        JSONResult data = new JSONResult();
        AuthUser authUser = iAuthUserService.singIn(input.getLoginStr(),input.getPassword());
        return data;
    }

}
