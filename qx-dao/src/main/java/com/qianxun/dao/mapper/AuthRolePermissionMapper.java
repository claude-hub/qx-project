package com.qianxun.dao.mapper;

import com.qianxun.entity.AuthRolePermission;
import java.util.List;

public interface AuthRolePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthRolePermission record);

    AuthRolePermission selectByPrimaryKey(Integer id);

    List<AuthRolePermission> selectAll();

    int updateByPrimaryKey(AuthRolePermission record);
}