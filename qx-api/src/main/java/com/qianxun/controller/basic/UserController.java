package com.qianxun.controller.basic;

import com.qianxun.controller.BaseController;
import com.qianxun.utils.BeanMapper;
import com.qianxun.dto.*;
import com.qianxun.service.UserService;
import com.qianxun.entity.User;
import com.qianxun.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@ResponseBody
//@Controller
@RestController
public class UserController extends BaseController {

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
    public JSONResult getAllUser() {
        JSONResult<List<User>> jsonResult = new JSONResult<>();
        List<User> allUser = userService.getAllUser();
        jsonResult.setData(allUser);
        return jsonResult;
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
        return userService.deleteUser(input.getId());
    }

    @GetMapping("/currentUser")
    public User currentUser(){
        return getCurrentUser();
    }
}
