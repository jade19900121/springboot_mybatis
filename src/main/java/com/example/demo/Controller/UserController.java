package com.example.demo.Controller;

import com.example.demo.Dao.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author fangjiulin
 * @version 1.0
 * @date 2021/4/8 0008 上午 9:38
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public int add(@RequestBody User user) {
        return userService.addUser(user);
    }

    @ResponseBody
    @PostMapping("/search")
    public User searchById(@RequestBody User user) {
        return userService.searchById(user.getId());
    }

    @ResponseBody
    @PostMapping("/searchall")
    public List<User> searchAll() {
        return userService.searchAll();
    }
    //我的
}