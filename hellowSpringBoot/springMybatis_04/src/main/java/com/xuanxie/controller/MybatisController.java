package com.xuanxie.controller;

import com.xuanxie.mapper.UserMapper;
import com.xuanxie.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class MybatisController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getAllUsers")
    public List<Users> getAllUsers(){
        System.out.println("=============================");
        System.out.println("进入了getAllUsers方法");
        System.out.println(userMapper==null);
        List<Users> allUsers = userMapper.getAllUsers();
        for (Users allUser : allUsers) {
            System.out.println(allUser);
        }
        return allUsers;
    }

    @RequestMapping("/getUserById/{id}")
    public String getUserById(@PathVariable int id){
        Users userById = userMapper.getUserById(id);
        System.out.println(userById);
        return userById.toString();
    }


    @RequestMapping("/deleteUserById/{id}")
    public String deleteUserById(@PathVariable int id){
        int i = userMapper.deleteUserById(id);
        if(i!=1){
            return "删除失败";
        }
        return "删除成功";
    }

    @RequestMapping("/addUser")
    public String getUserById(){
        System.err.println("新增员工");
        int count = userMapper.addUser(new Users(9, "测试新增用户", "123456"));
        if(count!=1){
            return "新增失败";
        }
        return "新增成功";
    }

}
