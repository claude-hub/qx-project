package com.qianxun.admin.mapper;

import com.qianxun.admin.model.entity.SysMenu;

import java.util.List;

/**
 * 菜单权限表
 *
 * @author cloudy
 * @date 2018-07-02 16:23:19
 */

 public interface SysMenuMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SysMenu record);

    SysMenu selectByPrimaryKey(Integer id);

    List<SysMenu> selectAll();

    int updateByPrimaryKey(SysMenu record);

}