package com.qianxun.admin.dao;

import com.qianxun.admin.entity.SysRole;

import java.util.List;

/**
 * 角色表
 *
 * @author cloudy
 * @date 2018-06-12 22:23:27
 */

 public interface SysRoleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    List<SysRole> selectAll();

    int updateByPrimaryKey(SysRole record);

}