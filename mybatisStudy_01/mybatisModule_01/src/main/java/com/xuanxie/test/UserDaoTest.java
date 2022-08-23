package com.xuanxie.test;

import com.xuanxie.dao.UserDao;
import com.xuanxie.pojo.User;
import com.xuanxie.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void getAllUser(){
        //获得SqlSession对象,其实相当于以前的statement对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行sql
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //相当于自己帮我们实现了一个接口实现类并返回
        //接下来可以使用该对象执行方法

        List<User> userList = mapper.getUserList();

        //输出结果
        for (User user : userList) {
            System.out.println(userList);
        }


    }
}
