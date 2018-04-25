package com.qianxun.dao.mapper;

import com.qianxun.entity.User;

import java.util.List;

public interface UserMapper {
    User selectByPrimaryKey(Integer id);

    int insert(User user);

    int updateByPrimaryKey(User user);

    int deleteByPrimaryKey(Integer id);

    List<User> selectAllUser();
}
