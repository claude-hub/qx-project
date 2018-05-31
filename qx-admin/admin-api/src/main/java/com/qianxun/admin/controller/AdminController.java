package com.qianxun.admin.controller;

import com.qianxun.dto.RequestDTO;
import com.qianxun.dto.sys.SysUserFormInputDTO;
import com.qianxun.dto.sys.SysUserLoginDTO;
import com.qianxun.dto.sys.SysUserLoginInputDTO;
import com.qianxun.entity.SysUser;
import com.qianxun.service.ISysUserService;
import com.qianxun.service.exception.AuthenticateException;
import com.qianxun.utils.BeanMapper;
import com.qianxun.utils.result.JSONResult;
import com.qianxun.utils.exception.InvalidException;
import com.qianxun.utils.exception.PhoneException;
import com.qianxun.utils.phone.PhoneHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "api/admin")
public class AdminController extends BaseController{
    @Autowired
    private ISysUserService iSysUserService;

    private PhoneHelper phoneHelper = PhoneHelper.getPhoneHelper();

    @PostMapping("/getUser")
    public SysUser getUser(@Valid @ModelAttribute RequestDTO input){
        return getCurrentUser();
    }
    /**
     * 添加管理员
     */
    @PostMapping("/add")
    public JSONResult createSysUser(@Valid @ModelAttribute SysUserFormInputDTO input) throws PhoneException, InvalidException {
        //判断是否是手机号
        phoneHelper.isMobileExact(input.getPhone());
        JSONResult data = new JSONResult();
        SysUser sysUser = BeanMapper.map(input,SysUser.class);
        data.setData(iSysUserService.addSysUser(sysUser,input.getPassword()));
        return data;
    }
    /**
     * 登录
     */
    @PostMapping("/sign_in")
    public JSONResult sign_in(@ModelAttribute @Valid SysUserLoginInputDTO input) throws AuthenticateException{
        JSONResult data = new JSONResult();
        SysUser sysUser = iSysUserService.signIn(input.getLoginStr(),input.getPassword());
        data.setData(BeanMapper.map(sysUser,SysUserLoginDTO.class));
        return data;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADD_PERMISSION')")
    @PostMapping("/test1")
    public JSONResult test1(@Valid @ModelAttribute RequestDTO input){
        JSONResult data = new JSONResult();
        return data;
    }
}