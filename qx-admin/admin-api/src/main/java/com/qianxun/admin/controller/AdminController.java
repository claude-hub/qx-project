package com.qianxun.admin.controller;

import com.qianxun.dto.sys.SysUserFormInputDTO;
import com.qianxun.entity.SysUser;
import com.qianxun.service.ISysUserService;
import com.qianxun.utils.BeanMapper;
import com.qianxun.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
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
    public JSONResult createSysUser(@Valid SysUserFormInputDTO input){
        JSONResult data = new JSONResult();
        SysUser sysUser = BeanMapper.map(input,SysUser.class);
        data.setData(iSysUserService.addSysUser(sysUser,input.getPassword()));
        return data;
    }
}