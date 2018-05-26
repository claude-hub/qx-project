package com.qianxun.admin.controller;

import com.qianxun.dto.sys.SysUserFormInputDTO;
import com.qianxun.dto.sys.SysUserLoginDTO;
import com.qianxun.dto.sys.SysUserLoginInputDTO;
import com.qianxun.entity.SysUser;
import com.qianxun.service.ISysUserService;
import com.qianxun.service.exception.AuthenticateException;
import com.qianxun.utils.BeanMapper;
import com.qianxun.utils.JSONResult;
import com.qianxun.utils.exception.InvalidException;
import com.qianxun.utils.exception.PhoneException;
import com.qianxun.utils.phone.PhoneHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "admin")
public class AdminController extends BaseController{
    private final ISysUserService iSysUserService;
    private PhoneHelper phoneHelper = PhoneHelper.getPhoneHelper();

    @Autowired
    public AdminController(ISysUserService iSysUserService){
        this.iSysUserService = iSysUserService;
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/getUser")
    public SysUser getUser(){
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
    public JSONResult sign_in(@RequestBody @ModelAttribute @Valid SysUserLoginInputDTO input) throws AuthenticateException{
        JSONResult data = new JSONResult();
        SysUser sysUser = iSysUserService.signIn(input.getLoginStr(),input.getPassword());
        data.setData(BeanMapper.map(sysUser,SysUserLoginDTO.class));
        return data;
    }

    @PostMapping("/test")
    public JSONResult test(@Valid SysUserLoginInputDTO input, BindingResult bindingResult) {
        JSONResult data = new JSONResult();
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            data.setData(bindingResult.getFieldError().getDefaultMessage());
            return data;
        }
        data.setData("验证成功!");
        return data;
    }
    @PostMapping("/test1")
    public JSONResult test1(@RequestBody @Valid SysUserLoginInputDTO input) {
        JSONResult data = new JSONResult();
        data.setData("验证成功!");
        return data;
    }
}