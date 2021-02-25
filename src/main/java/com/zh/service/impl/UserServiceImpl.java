package com.zh.service.impl;

import com.zh.dao.UserDao;
import com.zh.domain.User;
import com.zh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
//    注册
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User login(User user) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("email", user.getEmail());
        map.put("password", user.getPassword());
        return userDao.findUserByCondition(map);
    }

    @Override
    public User checkEmail(String email) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("email",email);
        return userDao.findUserByCondition(map);
    }
}
