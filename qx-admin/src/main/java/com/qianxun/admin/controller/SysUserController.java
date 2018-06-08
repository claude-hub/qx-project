package com.qianxun.admin.controller;

import com.qianxun.admin.BaseController;
import com.qianxun.admin.dto.user.*;
import com.qianxun.admin.entity.SysUser;
import com.qianxun.admin.service.SysUserService;
import com.qianxun.common.utils.mapper.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.qianxun.common.utils.result.JSONResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

/**
 * 用户表
 *
 * @author cloudy
 * @date 2018-06-08 12:04:33
 */
@RestController
@RequestMapping("/admin/SysUser")
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 分页查询
     * @param input
     * @return
     */
    @GetMapping("/query")
    public JSONResult query(@Valid SysUserQueryInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setData(sysUserService.findAllSysUsers());
        return jsonResult;
    }

    /**
     * 新增
     * @param input
     * @return
     */
    @PostMapping("/add")
    public JSONResult add(@Valid SysUserAddInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        SysUser sysUser = BeanMapper.map(input,SysUser.class);
        jsonResult.setData(sysUserService.addSysUser(sysUser,input.getPassword()));
        return jsonResult;
    }

    /**
     * 删除
     * @param input
     * @return
     */
    @DeleteMapping("/delete")
    public JSONResult delete(@Valid SysUserDeleteInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setData(sysUserService.deleteSysUser(input.getId()));
        return jsonResult;
    }

    /**
     * 修改
     * @param input
     * @return
     */
    @PutMapping("/update")
    public JSONResult update(@Valid SysUserUpdateInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        SysUser sysUser = BeanMapper.map(input,SysUser.class);
        sysUser.setPasswordEncrypted(input.getPassword());
        jsonResult.setData(sysUserService.editSysUser(sysUser));
        return jsonResult;
    }
}