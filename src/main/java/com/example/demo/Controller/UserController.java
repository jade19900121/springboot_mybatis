package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.Dao.User;
import com.example.demo.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public int add(@RequestBody User user) {
        logger.info("正在添加用户信息:{}", JSON.toJSONString(user));
        return userService.addUser(user);
    }

    @ResponseBody
    @PostMapping("/search")
    public User searchById(@RequestBody User user) {
        logger.info("正在查询的用户参数是{}", JSON.toJSONString(user));
        return userService.searchById(user.getId());
    }

    @ResponseBody
    @PostMapping("/searchall")
    public List<User> searchAll() {
        return userService.searchAll();
    }
    //我的
}