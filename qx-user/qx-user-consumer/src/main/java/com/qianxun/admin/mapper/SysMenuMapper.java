package com.qianxun.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qianxun.admin.api.entity.SysMenu;
import com.qianxun.admin.api.vo.MenuVO;

import java.util.List;

public interface SysMenuMapper extends BaseMapper<SysMenu> {

	/**
	 * 通过角色编号查询菜单
	 *
	 * @param roleId 角色ID
	 * @return
	 */
	List<MenuVO> listMenusByRoleId(Integer roleId);

	/**
	 * 通过角色ID查询权限
	 *
	 * @param roleIds Ids
	 * @return
	 */
	List<String> listPermissionsByRoleIds(String roleIds);
}
