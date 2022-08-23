package com.xuanxie.dao;

public class UerDapImpl implements UserDao{
    @Override
    public void addUser() {
        System.out.println("增加用户");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户");

    }

    @Override
    public void queryUser() {
        System.out.println("查询用户");
    }

    @Override
    public void updateUser() {
        System.out.println("更改用户");
    }
}
