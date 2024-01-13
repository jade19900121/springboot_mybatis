package com.example.demo.api.user;

import com.example.demo.Dao.User;

import java.util.List;

/**
 * @author fangjiulin
 * @version 1.0
 * @date 2021/4/8 0008 下午 1:43
 */
public interface UserService {
    int addUser(User user);

    User searchById(int Id);

    List<User> searchAll();
}
