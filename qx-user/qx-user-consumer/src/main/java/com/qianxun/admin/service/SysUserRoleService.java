package com.qianxun.admin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.qianxun.admin.api.entity.SysUserRole;

public interface SysUserRoleService extends IService<SysUserRole> {

	/**
	 * 根据用户Id删除该用户的角色关系
	 */
	Boolean removeRoleByUserId(Integer userId);
}
