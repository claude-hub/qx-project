package com.qianxun.admin.controller;

import com.qianxun.admin.dto.sysPermission.request.*;
import com.qianxun.admin.entity.SysPermission;
import com.qianxun.admin.service.SysPermissionService;
import com.qianxun.common.utils.mapper.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.qianxun.common.utils.result.JSONResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

/**
 * 用户权限表
 *
 * @author cloudy
 * @date 2018-06-12 22:49:20
 */
@RestController
@RequestMapping("/api/admin/SysPermission")
public class SysPermissionController extends BaseController {

    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * 分页查询
     * @param input
     * @return
     */
    @GetMapping("/query")
    public JSONResult query(@Valid SysPermissionQueryInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setData(sysPermissionService.findAllSysPermissions());
        return jsonResult;
    }

    /**
     * 新增
     * @param input
     * @return
     */
    @PostMapping("/add")
    public JSONResult add(@Valid SysPermissionAddInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        SysPermission sysPermission = BeanMapper.map(input,SysPermission.class);
        jsonResult.setData(sysPermissionService.addSysPermission(sysPermission));
        return jsonResult;
    }

    /**
     * 删除
     * @param input
     * @return
     */
    @DeleteMapping("/delete")
    public JSONResult delete(@Valid SysPermissionDeleteInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setData(sysPermissionService.deleteSysPermission(input.getId()));
        return jsonResult;
    }

    /**
     * 修改
     * @param input
     * @return
     */
    @PutMapping("/update")
    public JSONResult update(@Valid SysPermissionUpdateInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        SysPermission sysPermission = BeanMapper.map(input,SysPermission.class);
        jsonResult.setData(sysPermissionService.editSysPermission(sysPermission));
        return jsonResult;
    }
}