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
    /**
     * 添加用户信息
     * @param user
     * @return
     */
    int add(User user);

    /**
     * 根据id查询用户
     * @param Id
     * @return
     */
    User searchById(int Id);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> searchAll();
}