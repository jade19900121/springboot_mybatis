package com.example.demo.Service.user;

import com.example.demo.Dao.User;
import com.example.demo.Dao.UserDao;
import com.example.demo.api.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fangjiulin
 * @version 1.0
 * @date 2021/4/8 0008 下午 1:44
 */

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(User user) {
        return userDao.add(user);
    }

    @Override
    public User searchById(int userId) {
        return userDao.searchById(userId);
    }

    @Override
    public List<User> searchAll() {
        return userDao.searchAll();
    }
}
