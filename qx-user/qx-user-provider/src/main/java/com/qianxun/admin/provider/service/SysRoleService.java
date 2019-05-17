package com.qianxun.admin.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qianxun.admin.api.dto.extend.SysRoleDTO;
import com.qianxun.admin.api.dto.sysRole.request.SysRoleQueryInputDTO;
import com.qianxun.admin.api.dto.sysRole.request.SysRoleSearchByIdDTO;
import com.qianxun.admin.api.entity.SysRole;

import java.util.List;

/**
 * @author Cloudy
 * Date 2019-05-13 19:35:18
 */
public interface SysRoleService extends IService<SysRole> {

    SysRoleDTO searchById(SysRoleSearchByIdDTO inputDTO);

    Boolean saveSysRole(SysRoleDTO sysRoleDTO);

    IPage getSysRoles(Page page, SysRoleQueryInputDTO inputDTO);

    Boolean updateSysRole(SysRoleDTO sysRoleDTO);

    List<SysRoleDTO> getRolesByUserId(Integer userId);
}
