package com.qianxun.admin.controller;

import com.qianxun.dto.sys.SysUserFormInputDTO;
import com.qianxun.entity.SysUser;
import com.qianxun.service.ISysUserService;
import com.qianxun.utils.BeanMapper;
import com.qianxun.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "admin")
public class AdminController extends BaseController{
    private final ISysUserService iSysUserService;

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
    public JSONResult createSysUser(@Valid @ModelAttribute SysUserFormInputDTO input,BindingResult bindingResult){
        JSONResult data = new JSONResult();
        if(bindingResult.hasErrors()){
            data.setData(bindingResult.getFieldError().getDefaultMessage());
            return data;
        }
        SysUser sysUser = BeanMapper.map(input,SysUser.class);
        data.setData(iSysUserService.addSysUser(sysUser,input.getPassword()));
        return data;
    }
}