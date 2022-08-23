package com.xuanxie.dao;

import com.xuanxie.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {//CRUD
    //查询全部用户
    List<User> getUserList();

    //更加id查询用户
    User getUserById(int id);

    //删除
int deleteUser(int id);

    //改
    int updataUser(User user);

    //增
    int addUser2(User user);

    //万能的map
    int addUser2(Map<String,Object> map);

    //模糊查询
    List<User> getUsersLike(String pattern);

}
