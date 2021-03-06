package com.zh.service.impl;

import com.github.pagehelper.PageInfo;
import com.zh.dao.UserDao;
import com.zh.domain.User;
import com.zh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    @Override
    public PageInfo<User> findAllUser() {
        List<User> userList  = userDao.findUserAll();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }

    @Override
    public int delete(int uid) {
        HashMap<String , Object> map = new HashMap<>();
        map.put("id",uid);
        map.put("flag",0);
        return userDao.updateUser(map);
    }

    @Override
    public User findUserByIds(Integer id) {
        List<Integer> list = new ArrayList<>();
        list.add(id);
        return userDao.findUserByIds(list);
    }

    @Override
    public int updateUser(HashMap<String,Object> map) {
        return userDao.updateUser(map);
    }
}
