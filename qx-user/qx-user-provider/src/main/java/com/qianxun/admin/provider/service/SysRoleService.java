package com.qianxun.admin.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qianxun.admin.api.dto.base.UpdateDBResponseDTO;
import com.qianxun.admin.api.dto.sysRole.request.SysRolePermissionDTO;
import com.qianxun.admin.api.entity.SysRole;

import java.util.List;

/**
 * @author Cloudy
 * Date 2019-05-13 19:35:18
 */
public interface SysRoleService extends IService<SysRole> {
    List<SysRole> getRolesByUserId(Integer userId);

    UpdateDBResponseDTO addRolePerms(SysRolePermissionDTO dto);
}
