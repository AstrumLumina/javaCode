package com.xuanxie.service;

import com.xuanxie.dao.UserDao;
import org.junit.Test;

public class UserService {
    UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao=userDao;
    }
    public void userService() {
        System.out.println(userDao.dateBase());
    }
}
