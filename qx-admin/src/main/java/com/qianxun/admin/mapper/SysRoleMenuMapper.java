package com.qianxun.admin.mapper;

import com.qianxun.admin.model.entity.SysRoleMenu;

import java.util.List;

/**
 * 角色菜单表
 *
 * @author cloudy
 * @date 2018-06-29 17:20:13
 */

 public interface SysRoleMenuMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleMenu record);

    SysRoleMenu selectByPrimaryKey(Integer id);

    List<SysRoleMenu> selectAll();

    int updateByPrimaryKey(SysRoleMenu record);

}