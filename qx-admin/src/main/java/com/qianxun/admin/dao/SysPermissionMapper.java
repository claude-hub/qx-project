package com.qianxun.admin.dao;

import com.qianxun.admin.entity.SysPermission;

import java.util.List;

/**
 * 用户权限表
 *
 * @author cloudy
 * @date 2018-06-12 22:49:20
 */

 public interface SysPermissionMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SysPermission record);

    SysPermission selectByPrimaryKey(Integer id);

    List<SysPermission> selectAll();

    int updateByPrimaryKey(SysPermission record);

}