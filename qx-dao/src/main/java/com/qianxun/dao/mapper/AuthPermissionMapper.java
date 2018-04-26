package com.qianxun.dao.mapper;

import com.qianxun.entity.AuthPermission;
import java.util.List;

public interface AuthPermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthPermission record);

    AuthPermission selectByPrimaryKey(Integer id);

    List<AuthPermission> selectAll();

    int updateByPrimaryKey(AuthPermission record);
}