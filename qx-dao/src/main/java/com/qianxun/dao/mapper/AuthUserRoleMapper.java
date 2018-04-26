package com.qianxun.dao.mapper;

import com.qianxun.entity.AuthUserRole;
import java.util.List;

public interface AuthUserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthUserRole record);

    AuthUserRole selectByPrimaryKey(Integer id);

    List<AuthUserRole> selectAll();

    int updateByPrimaryKey(AuthUserRole record);
}