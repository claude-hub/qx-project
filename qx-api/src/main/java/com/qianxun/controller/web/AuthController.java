package com.qianxun.controller.web;

import com.qianxun.dto.UserLoginInputDTO;
import com.qianxun.entity.AuthUser;
import com.qianxun.service.AuthUserService;
import com.qianxun.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

public class AuthController {
    private final AuthUserService authUserService;

    @Autowired
    public AuthController(AuthUserService authUserService){
        this.authUserService = authUserService;
    }

    @PostMapping("/sing_in")
    public JSONResult singIn(UserLoginInputDTO input){
        JSONResult data = new JSONResult();
        AuthUser authUser = authUserService.singIn(input.getLoginStr(),input.getPassword());
        return data;
    }

}
