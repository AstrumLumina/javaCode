package com.xuanxie.dao;

import com.xuanxie.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {//CRUD

    //更加id查询用户
    User getUserById(int id);

    //分页查询
    List<User> getUserByLimit(Map<String,Integer> map);

}
