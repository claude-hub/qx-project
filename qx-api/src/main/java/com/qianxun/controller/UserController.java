package com.qianxun.controller;

import com.qianxun.BeanMapper;
import com.qianxun.dto.*;
import com.qianxun.service.UserService;
import com.qianxun.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@ResponseBody
//@Controller
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/user")
    public User getUserById(UserSearchByIdDTO input) {
        User user = userService.getUserById(input.getId());
        return user;
    }

    @GetMapping("/allUser")
    public List<User> getAllUser() {
        List<User> allUser = userService.getAllUser();
        return allUser;
    }

    @PostMapping("/addUser")
    public User addUser(UserAddDTO input) {
        User user = BeanMapper.map(input, User.class);
        userService.addUser(user);
        return user;
    }

    @PutMapping("/updateUser")
    public User updateUser(UserEditDTO input) {
        User user = BeanMapper.map(input, User.class);
        userService.updateUser(user);
        return user;
    }

    @DeleteMapping("/deleteUser")
    public boolean deleteUser(UserDeleteDTO input) {
        boolean succes = userService.deleteUser(input.getId());
        return succes;
    }
}
