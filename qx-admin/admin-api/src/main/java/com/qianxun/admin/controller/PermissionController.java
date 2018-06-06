package com.qianxun.admin.controller;

import com.qianxun.dto.permission.AddPermissionFormInputDTO;
import com.qianxun.entity.SysPermission;
import com.qianxun.service.ISysPermissionService;
import com.qianxun.utils.BeanMapper;
import com.qianxun.utils.result.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "api/admin/permission")
public class PermissionController extends BaseController{
    @Autowired
    private ISysPermissionService permissionService;
    /**
     * 添加权限
     * @return
     */
    @PostMapping("/add_permission")
    public JSONResult addPermission(@Valid @ModelAttribute AddPermissionFormInputDTO input){
        JSONResult data = new JSONResult();
        SysPermission permission = BeanMapper.map(input,SysPermission.class);
        data.setData(permissionService.addPermission(permission));
        return data;
    }
}
