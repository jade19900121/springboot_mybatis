package com.example.demo.Controller;

import com.example.demo.Dao.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fangjiulin
 * @version 1.0
 * @date 2021/4/8 0008 上午 9:38
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public int add(@RequestBody User user) {
        return userService.addUser(user);
    }

    //@ResponseBody
    //@PostMapping("/search")
    @RequestMapping("/search")
    public User searchById(@RequestBody User user) {
        return userService.searchById(user.getId());
    }

    //@ResponseBody
    //@PostMapping("/searchall")
    @RequestMapping("/searchall")
    public List<User> searchAll() {
        //log.error("error level");
        //log.info("程序现在进入到这里了，进行数据库查询");
        return userService.searchAll();
    }
}