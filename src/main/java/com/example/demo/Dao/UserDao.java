package com.example.demo.Dao;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fangjiulin
 * @version 1.0
 * @date 2021/4/8 0008 上午 9:56
 */
@Component
public interface UserDao {
    int add(User user);
    User searchById(int Id);
    List<User> searchAll();
}