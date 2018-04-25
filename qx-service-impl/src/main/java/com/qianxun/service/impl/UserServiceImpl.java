package com.qianxun.service.impl;

import com.qianxun.dao.mapper.UserMapper;
import com.qianxun.entity.User;
import com.qianxun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getUserById(Integer id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> getAllUser() {
        return this.userMapper.selectAllUser();
    }

    @Override
    public boolean addUser(User user) {
        return this.userMapper.insert(user) > 0;
    }

    @Override
    public boolean updateUser(User user) {
        return this.userMapper.updateByPrimaryKey(user) > 0;
    }

    @Override
    public boolean deleteUser(Integer id) {
        return this.userMapper.deleteByPrimaryKey(id) > 0;
    }
}
