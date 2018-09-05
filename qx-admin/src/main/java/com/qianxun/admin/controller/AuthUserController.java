package com.qianxun.admin.controller;

import com.qianxun.admin.model.dto.RequestDTO;
import com.qianxun.admin.model.dto.auth.request.AuthUserLoginInputDTO;
import com.qianxun.admin.model.dto.auth.response.AuthUserLoginDTO;
import com.qianxun.admin.model.dto.sysMenu.response.MenuTree;
import com.qianxun.admin.model.entity.SysMenu;
import com.qianxun.admin.model.entity.SysUser;
import com.qianxun.admin.exception.AuthenticateException;
import com.qianxun.admin.service.AuthUserService;
import com.qianxun.common.utils.captcha.CaptchaHelper;
import com.qianxun.common.utils.mapper.BeanMapper;
import com.qianxun.common.utils.result.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/admin/auth")
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
    public JSONResult sign_in(HttpServletRequest request, @RequestBody @Valid AuthUserLoginInputDTO input) throws AuthenticateException, CaptchaHelper.CaptchaException {
        JSONResult data = new JSONResult();
        // 验证，验证码
        captchaHelper.validateThrow(request, input.getCaptcha());
        SysUser sysUser = authUserService.signIn(input.getLoginStr(),input.getPassword());
        data.setData(BeanMapper.map(sysUser,AuthUserLoginDTO.class));
        return data;
    }

    @PreAuthorize("hasAnyRole('ROLE_SYSTEMM')")
    @PostMapping("/test1")
    public JSONResult test1(@Valid RequestDTO input){
        JSONResult data = new JSONResult();
        data.setMessage("请求成功");
        return data;
    }

    @PreAuthorize("hasAnyRole('ROLE_SYSTEM')")
    @PostMapping("/test2")
    public JSONResult test2(@Valid RequestDTO input){
        JSONResult data = new JSONResult();
        data.setMessage("请求成功");
        return data;
    }

    @GetMapping("/menu")
    public JSONResult menu(@Valid RequestDTO input){
        JSONResult data = new JSONResult();
        SysUser user = getCurrentUser();
        List<MenuTree> menus = authUserService.getUserMenuTree(user.getUserId());
        data.setData(menus);
        return data;
    }
}
