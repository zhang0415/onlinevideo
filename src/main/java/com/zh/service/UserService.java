package com.zh.service;

import com.zh.domain.User;

import java.util.HashMap;

public interface UserService {

    int insertUser(User user);

    public User login(User user);

    public User checkEmail(String email);
}
