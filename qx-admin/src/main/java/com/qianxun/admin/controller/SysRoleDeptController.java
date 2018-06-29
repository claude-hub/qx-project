package com.qianxun.admin.controller;

import com.qianxun.admin.dto.sysRoleDept.request.*;
import com.qianxun.admin.entity.SysRoleDept;
import com.qianxun.admin.service.SysRoleDeptService;
import com.qianxun.common.utils.mapper.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.qianxun.common.utils.result.JSONResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

/**
 * 角色与部门对应关系
 *
 * @author cloudy
 * @date 2018-06-29 17:20:13
 */
@RestController
@RequestMapping("SysRoleDept")
public class SysRoleDeptController extends BaseController {

    @Autowired
    private SysRoleDeptService sysRoleDeptService;

    /**
     * 分页查询
     * @param input
     * @return
     */
    @GetMapping("/query")
    public JSONResult query(@Valid SysRoleDeptQueryInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setData(sysRoleDeptService.findAllSysRoleDepts());
        return jsonResult;
    }

    /**
     * 新增
     * @param input
     * @return
     */
    @PostMapping("/add")
    public JSONResult add(@Valid SysRoleDeptAddInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        SysRoleDept sysRoleDept = BeanMapper.map(input,SysRoleDept.class);
        jsonResult.setData(sysRoleDeptService.addSysRoleDept(sysRoleDept));
        return jsonResult;
    }

    /**
     * 删除
     * @param input
     * @return
     */
    @DeleteMapping("/delete")
    public JSONResult delete(@Valid SysRoleDeptDeleteInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setData(sysRoleDeptService.deleteSysRoleDept(input.getId()));
        return jsonResult;
    }

    /**
     * 修改
     * @param input
     * @return
     */
    @PutMapping("/update")
    public JSONResult update(@Valid SysRoleDeptUpdateInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        SysRoleDept sysRoleDept = BeanMapper.map(input,SysRoleDept.class);
        jsonResult.setData(sysRoleDeptService.editSysRoleDept(sysRoleDept));
        return jsonResult;
    }
}