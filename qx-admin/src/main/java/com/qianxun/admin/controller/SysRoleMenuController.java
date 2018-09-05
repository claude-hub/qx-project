package com.qianxun.admin.controller;

import com.qianxun.admin.model.dto.sysRoleMenu.request.*;
import com.qianxun.admin.model.entity.SysRoleMenu;
import com.qianxun.admin.service.SysRoleMenuService;
import com.qianxun.common.utils.mapper.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.qianxun.common.utils.result.JSONResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

/**
 * 角色菜单表
 *
 * @author cloudy
 * @date 2018-06-29 17:20:13
 */
@RestController
@RequestMapping("/api/admin/sysRoleMenu")
public class SysRoleMenuController extends BaseController {

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 分页查询
     * @param input
     * @return
     */
    @GetMapping("/query")
    public JSONResult query(@Valid SysRoleMenuQueryInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setData(sysRoleMenuService.findAllSysRoleMenus());
        return jsonResult;
    }

    /**
     * 新增
     * @param input
     * @return
     */
    @PostMapping("/add")
    public JSONResult add(@Valid SysRoleMenuAddInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        SysRoleMenu sysRoleMenu = BeanMapper.map(input,SysRoleMenu.class);
        jsonResult.setData(sysRoleMenuService.addSysRoleMenu(sysRoleMenu));
        return jsonResult;
    }

    /**
     * 删除
     * @param input
     * @return
     */
    @DeleteMapping("/delete")
    public JSONResult delete(@Valid SysRoleMenuDeleteInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setData(sysRoleMenuService.deleteSysRoleMenu(input.getId()));
        return jsonResult;
    }

    /**
     * 修改
     * @param input
     * @return
     */
    @PutMapping("/update")
    public JSONResult update(@Valid SysRoleMenuUpdateInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        SysRoleMenu sysRoleMenu = BeanMapper.map(input,SysRoleMenu.class);
        jsonResult.setData(sysRoleMenuService.editSysRoleMenu(sysRoleMenu));
        return jsonResult;
    }
}