package com.xuanxie.service;

import com.xuanxie.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserSeviceImpl implements UserService{
    @Override
    public User getUser(User user) {
        return  user;
    }

}
