package com.qianxun.admin.dao;

import com.qianxun.admin.entity.SysUserRole;

import java.util.List;

/**
 * 用户角色表
 *
 * @author cloudy
 * @date 2018-06-29 17:20:12
 */

 public interface SysUserRoleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SysUserRole record);

    SysUserRole selectByPrimaryKey(Integer id);

    List<SysUserRole> selectAll();

    int updateByPrimaryKey(SysUserRole record);

}