package com.example.demo.Service;

import com.example.demo.Controller.UserController;
import com.example.demo.Dao.User;
import com.example.demo.Dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fangjiulin
 * @version 1.0
 * @date 2021/4/8 0008 下午 1:44
 */

//1111
@Service(value = "userService")
public class UserServiceImpl implements UserService{
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

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
        log.error("程序现在进入到这里了");
        return userDao.searchAll();
    }
}
