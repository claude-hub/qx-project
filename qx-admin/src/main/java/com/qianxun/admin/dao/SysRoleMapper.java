package com.qianxun.admin.dao;

import com.qianxun.admin.entity.SysRole;

import java.util.List;

/**
 * 
 *
 * @author cloudy
 * @date 2018-06-29 17:20:12
 */

 public interface SysRoleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    List<SysRole> selectAll();

    int updateByPrimaryKey(SysRole record);

}