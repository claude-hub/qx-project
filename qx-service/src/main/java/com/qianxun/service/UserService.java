package com.qianxun.service;

import com.qianxun.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(Integer id);

    List<User> getAllUser();

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(Integer id);
}
