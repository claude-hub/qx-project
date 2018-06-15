package com.qianxun.admin.controller;

import com.qianxun.admin.dto.sysUser.requset.SysUserAddInputDTO;
import com.qianxun.admin.dto.sysUser.requset.SysUserDeleteInputDTO;
import com.qianxun.admin.dto.sysUser.requset.SysUserQueryInputDTO;
import com.qianxun.admin.dto.sysUser.requset.SysUserUpdateInputDTO;
import com.qianxun.admin.entity.SysUser;
import com.qianxun.admin.service.SysUserService;
import com.qianxun.common.utils.exception.InvalidException;
import com.qianxun.common.utils.exception.PhoneException;
import com.qianxun.common.utils.mapper.BeanMapper;
import com.qianxun.common.utils.phone.PhoneHelper;
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
@RequestMapping("/api/admin/SysUser")
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    private PhoneHelper phoneHelper = PhoneHelper.getPhoneHelper();

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
    public JSONResult add(@Valid SysUserAddInputDTO input) throws PhoneException, InvalidException {
        JSONResult jsonResult = new JSONResult();
        //判断是否是手机号
        phoneHelper.isMobileExact(input.getPhone());
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