package com.qianxun.admin.controller;

import com.qianxun.admin.dto.RequestDTO;
import com.qianxun.admin.dto.auth.request.AuthUserLoginInputDTO;
import com.qianxun.admin.dto.auth.response.AuthUserLoginDTO;
import com.qianxun.admin.entity.SysUser;
import com.qianxun.admin.exception.AuthenticateException;
import com.qianxun.admin.service.AuthUserService;
import com.qianxun.common.utils.mapper.BeanMapper;
import com.qianxun.common.utils.result.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "api/admin/auth")
public class AuthUserController extends BaseController {
    @Autowired
    private AuthUserService authUserService;

    @PostMapping("/getUser")
    public SysUser getUser(@Valid RequestDTO input){
        return getCurrentUser();
    }
    /**
     * 登录
     */
    @PostMapping("/sign_in")
    public JSONResult sign_in(@Valid AuthUserLoginInputDTO input) throws AuthenticateException {
        JSONResult data = new JSONResult();
        SysUser sysUser = authUserService.signIn(input.getLoginStr(),input.getPassword());
        data.setData(BeanMapper.map(sysUser,AuthUserLoginDTO.class));
        return data;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADD_PERMISSION')")
    @PostMapping("/test1")
    public JSONResult test1(@Valid RequestDTO input){
        JSONResult data = new JSONResult();
        return data;
    }
}
