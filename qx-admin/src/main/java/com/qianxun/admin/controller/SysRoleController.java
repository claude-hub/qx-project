package com.qianxun.admin.controller;

import com.qianxun.admin.dto.sysRole.request.*;
import com.qianxun.admin.entity.SysRole;
import com.qianxun.admin.service.SysRoleService;
import com.qianxun.common.utils.mapper.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.qianxun.common.utils.result.JSONResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

/**
 * 角色表
 *
 * @author cloudy
 * @date 2018-06-12 22:23:27
 */
@RestController
@RequestMapping("/api/admin/SysRole")
public class SysRoleController extends BaseController {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 分页查询
     * @param input
     * @return
     */
    @GetMapping("/query")
    public JSONResult query(@Valid SysRoleQueryInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setData(sysRoleService.findAllSysRoles());
        return jsonResult;
    }

    /**
     * 新增
     * @param input
     * @return
     */
    @PostMapping("/add")
    public JSONResult add(@Valid SysRoleAddInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        SysRole sysRole = BeanMapper.map(input,SysRole.class);
        jsonResult.setData(sysRoleService.addSysRole(sysRole));
        return jsonResult;
    }

    /**
     * 删除
     * @param input
     * @return
     */
    @DeleteMapping("/delete")
    public JSONResult delete(@Valid SysRoleDeleteInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setData(sysRoleService.deleteSysRole(input.getId()));
        return jsonResult;
    }

    /**
     * 修改
     * @param input
     * @return
     */
    @PutMapping("/update")
    public JSONResult update(@Valid SysRoleUpdateInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        SysRole sysRole = BeanMapper.map(input,SysRole.class);
        jsonResult.setData(sysRoleService.editSysRole(sysRole));
        return jsonResult;
    }
}