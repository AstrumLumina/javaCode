package com.xuanxie.service;

import com.xuanxie.pojo.Users;

import java.util.List;


public interface UserService {
    Users getUserById(int id);
    String getPwdByName(String name);
    public List<Users> getUsersByName(String name);
}
