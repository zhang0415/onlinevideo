package com.zh.dao;


import com.zh.domain.User;

import java.util.HashMap;

public interface UserDao {

    int insertUser(User user);

    User findUserByCondition(HashMap<String,Object> map);
}