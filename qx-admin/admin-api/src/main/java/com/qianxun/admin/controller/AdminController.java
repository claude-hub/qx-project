package com.qianxun.admin.controller;

import com.qianxun.dto.sys.SysUserFormInputDTO;
import com.qianxun.entity.SysUser;
import com.qianxun.service.ISysUserService;
import com.qianxun.utils.BeanMapper;
import com.qianxun.utils.JSONResult;
import com.qianxun.utils.exception.InvalidException;
import com.qianxun.utils.exception.PhoneException;
import com.qianxun.utils.phone.PhoneHelper;
import org.springframework.beans.factory.annotation.Autowired;
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
}