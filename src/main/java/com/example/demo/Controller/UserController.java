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
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public int add(@RequestBody User user) {
        return userService.addUser(user);
    }

    @ResponseBody
    @PostMapping("/search")
    public User searchById(@RequestBody User user) {
        //log.error("Something else is wrong here");
        return userService.searchById(user.getId());
    }

    @ResponseBody
    @PostMapping("/searchall")
    public List<User> searchAll() {
        log.error("Something else is wrong here");
        return userService.searchAll();
    }
}