package com.qianxun.controller;

import com.qianxun.bean.User;
import com.qianxun.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@ResponseBody
//@Controller
@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    //@RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        User user = userMapper.getUserById(id);
        return user;
    }

    @GetMapping("/allUser")
    public List<User> getAllUser() {
        List<User> allUser = userMapper.getAllUser();
        return allUser;
    }

    @PostMapping("/addUser")
    public User addUser(User user) {
        userMapper.addUser(user);
        return user;
    }

    @PutMapping("/updateUser")
    public User updateUser(User user) {
        userMapper.updateUser(user);
        return user;
    }

    @DeleteMapping("/deleteUser/{id}")
    public int deleteUser(@PathVariable("id") Integer id) {
        userMapper.deleteUser(id);
        return id;
    }
}
