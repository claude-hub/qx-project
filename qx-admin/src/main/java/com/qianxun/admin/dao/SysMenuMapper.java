package com.qianxun.admin.dao;

import com.qianxun.admin.entity.SysMenu;

import java.util.List;

/**
 * 菜单权限表
 *
 * @author cloudy
 * @date 2018-06-29 17:20:12
 */

 public interface SysMenuMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SysMenu record);

    SysMenu selectByPrimaryKey(Integer id);

    List<SysMenu> selectAll();

    int updateByPrimaryKey(SysMenu record);

}