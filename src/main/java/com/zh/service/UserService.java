package com.zh.service;

import com.github.pagehelper.PageInfo;
import com.zh.domain.User;

import java.util.HashMap;

public interface UserService {

    int insertUser(User user);

    User login(User user);

    User checkEmail(String email);

    PageInfo<User> findAllUser();

    int delete(int uid);

    User findUserByIds(Integer id);

    int updateUser(HashMap<String,Object> map);
}
