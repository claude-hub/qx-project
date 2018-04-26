package com.qianxun.dao.mapper;

import com.qianxun.entity.AuthRole;
import java.util.List;

public interface AuthRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthRole record);

    AuthRole selectByPrimaryKey(Integer id);

    List<AuthRole> selectAll();

    int updateByPrimaryKey(AuthRole record);
}