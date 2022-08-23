package com.xuanxie.dao;


import com.xuanxie.pojo.User;
import com.xuanxie.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void  getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession(true);
        try{
            UserMapper userDao = sqlSession.getMapper(UserMapper.class);
            User userById = userDao.getUserById(2);
            System.out.println(userById);
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    @Test
    public void getUserByName(){
        SqlSession sqlSession = MybatisUtils.getSqlSession(true);//设置自动提交事物
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByName("小丽");
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int count = mapper.addUser(new User(6, "小红", "123456"));
        if(count==1){
            System.out.println("事务成功");
        }else{
            System.out.println("事务失败");
        }
        sqlSession.close();
    }

    @Test
    public void getAllUsers(){
        SqlSession sqlSession = MybatisUtils.getSqlSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        for (User user : mapper.getAllUser()) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int count = mapper.updateUser(new User(6, "小小", "123456"));
        sqlSession.close(); if(count==1){
            System.out.println("事务成功");
        }else{
            System.out.println("事务失败");
        }
        sqlSession.close();
    }
}
