package com.qianxun.admin.controller;

import com.qianxun.admin.model.dto.sysMenu.request.*;
import com.qianxun.admin.model.entity.SysMenu;
import com.qianxun.admin.service.SysMenuService;
import com.qianxun.common.utils.mapper.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.qianxun.common.utils.result.JSONResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

/**
 * 菜单权限表
 *
 * @author cloudy
 * @date 2018-07-02 16:32:14
 */
@RestController
@RequestMapping("SysMenu")
public class SysMenuController extends BaseController {

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 分页查询
     * @param input
     * @return
     */
    @GetMapping("/query")
    public JSONResult query(@Valid SysMenuQueryInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setData(sysMenuService.findAllSysMenus());
        return jsonResult;
    }

    /**
     * 新增
     * @param input
     * @return
     */
    @PostMapping("/add")
    public JSONResult add(@Valid SysMenuAddInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        SysMenu sysMenu = BeanMapper.map(input,SysMenu.class);
        jsonResult.setData(sysMenuService.addSysMenu(sysMenu));
        return jsonResult;
    }

    /**
     * 删除
     * @param input
     * @return
     */
    @DeleteMapping("/delete")
    public JSONResult delete(@Valid SysMenuDeleteInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setData(sysMenuService.deleteSysMenu(input.getId()));
        return jsonResult;
    }

    /**
     * 修改
     * @param input
     * @return
     */
    @PutMapping("/update")
    public JSONResult update(@Valid SysMenuUpdateInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        SysMenu sysMenu = BeanMapper.map(input,SysMenu.class);
        jsonResult.setData(sysMenuService.editSysMenu(sysMenu));
        return jsonResult;
    }
}