package com.zh.dao;


import com.zh.domain.User;

import java.util.HashMap;
import java.util.List;

public interface UserDao {

    int insertUser(User user);

    User findUserByCondition(HashMap<String,Object> map);

    List<User> findUserAll();

    int updateUser(HashMap<String,Object> map);

    User findUserByIds(List<Integer> list);

}