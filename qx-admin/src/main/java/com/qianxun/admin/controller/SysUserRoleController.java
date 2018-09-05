package com.qianxun.admin.controller;

import com.qianxun.admin.model.dto.sysUserRole.request.*;
import com.qianxun.admin.model.entity.SysUserRole;
import com.qianxun.admin.service.SysUserRoleService;
import com.qianxun.common.utils.mapper.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.qianxun.common.utils.result.JSONResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

/**
 * 用户角色表
 *
 * @author cloudy
 * @date 2018-06-29 17:20:12
 */
@RestController
@RequestMapping("/api/admin/sysUserRole")
public class SysUserRoleController extends BaseController {

    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 分页查询
     * @param input
     * @return
     */
    @GetMapping("/query")
    public JSONResult query(@Valid SysUserRoleQueryInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setData(sysUserRoleService.findAllSysUserRoles());
        return jsonResult;
    }

    /**
     * 新增
     * @param input
     * @return
     */
    @PostMapping("/add")
    public JSONResult add(@Valid SysUserRoleAddInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        SysUserRole sysUserRole = BeanMapper.map(input,SysUserRole.class);
        jsonResult.setData(sysUserRoleService.addSysUserRole(sysUserRole));
        return jsonResult;
    }

    /**
     * 删除
     * @param input
     * @return
     */
    @DeleteMapping("/delete")
    public JSONResult delete(@Valid SysUserRoleDeleteInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setData(sysUserRoleService.deleteSysUserRole(input.getId()));
        return jsonResult;
    }

    /**
     * 修改
     * @param input
     * @return
     */
    @PutMapping("/update")
    public JSONResult update(@Valid SysUserRoleUpdateInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        SysUserRole sysUserRole = BeanMapper.map(input,SysUserRole.class);
        jsonResult.setData(sysUserRoleService.editSysUserRole(sysUserRole));
        return jsonResult;
    }
}