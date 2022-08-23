package com.xuanxie.service;

public class UserServiceImpl implements UserService{
    @Override
    public void addUser() {
        System.out.println("增加了一个用户");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除了一个用户");

    }

    @Override
    public void selectUser() {
        System.out.println("查询了一个用户");
    }

    @Override
    public void updateUser() {
        System.out.println("更改了一个用户");
    }
}
