package com.qianxun.admin.controller;

import com.qianxun.admin.dto.RequestDTO;
import com.qianxun.admin.dto.auth.request.AuthUserLoginInputDTO;
import com.qianxun.admin.dto.auth.response.AuthUserLoginDTO;
import com.qianxun.admin.entity.SysUser;
import com.qianxun.admin.exception.AuthenticateException;
import com.qianxun.admin.service.AuthUserService;
import com.qianxun.common.utils.captcha.CaptchaHelper;
import com.qianxun.common.utils.mapper.BeanMapper;
import com.qianxun.common.utils.result.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "auth")
@CrossOrigin
public class AuthUserController extends BaseController {
    private CaptchaHelper captchaHelper = CaptchaHelper.getCaptchaHelper();

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
    @CrossOrigin
    public JSONResult sign_in(@RequestBody @Valid AuthUserLoginInputDTO input) throws AuthenticateException {
        JSONResult data = new JSONResult();
        // 验证，验证码
//        captchaHelper.validateThrow(request, input.getCaptcha());
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
