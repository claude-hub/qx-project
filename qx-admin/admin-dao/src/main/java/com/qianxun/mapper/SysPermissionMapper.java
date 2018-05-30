package com.qianxun.mapper;

import com.qianxun.entity.SysPermission;

import java.util.List;

public interface SysPermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysPermission record);

    SysPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(SysPermission record);

    List<SysPermission> findPermissionsByUserId(Integer id);
}