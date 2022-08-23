package com.xuanxie.dao;

import com.xuanxie.dao.UserMapper;
import com.xuanxie.pojo.User;
import com.xuanxie.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void  getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            UserMapper userDao = sqlSession.getMapper(UserMapper.class);
            User userByID = userDao.getUserById(4);
            System.out.println(userByID);
        }finally {
            sqlSession.close();
        }
        //  select * form Users　where id=4
        //相当于 select id,name,pwd from Users where id=4
        //可以通过映解决,取别名解决
        //取别名 更改xml文件的sql语句为 :  select id,name,pwd as password from Users where id=4
        //结果集映射

    }

}
