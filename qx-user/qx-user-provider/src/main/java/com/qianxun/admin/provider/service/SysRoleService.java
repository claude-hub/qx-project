package com.qianxun.admin.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qianxun.admin.api.dto.extend.SysRoleDTO;
import com.qianxun.admin.api.dto.sysRole.request.SysRoleQueryInputDTO;
import com.qianxun.admin.api.entity.SysRole;

/**
 * author: Claude
 * email: 314705487@qq.com
 * create date: 05/10/19 9:31
 */
public interface SysRoleService extends IService<SysRole> {

    Boolean saveRole(SysRoleDTO sysRoleDTO);

    IPage getRoles(Page page, SysRoleQueryInputDTO inputDTO);

    Boolean updateRole(SysRoleDTO sysRoleDTO);
}
