package com.xuanxie.service;

import com.xuanxie.mapper.UserMapper;
import com.xuanxie.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSeviceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public Users getUserById(int id) {
       return userMapper.getUserById(id);
    }

    @Override
    public String getPwdByName(String name) {
        return userMapper.getPwdByName(name);
    }

    @Override
    public List<Users> getUsersByName(String name) {
        return userMapper.getUsersByName(name);
    }
}
