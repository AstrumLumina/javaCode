package com.xuanxie.dao;

import com.xuanxie.dao.UserMapper;
import com.xuanxie.pojo.User;
import com.xuanxie.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.*;


public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);

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
    }


    @Test
    public void log4jTest(){
        logger.info("info:使用log4j输出日志,级别位info");
        logger.debug("debge:使用log4j输出日志,级别位debuge");
        logger.error("error:使用log4j输出日志,级别位error");
    }

    //分页查询测试
    @Test
    public void pageQuery(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Integer> map=new HashMap<String,Integer>();
        int page=0;
        int pageSize=2;
        map.put("pageSize",pageSize);
        List<User> userByLimit=null;
        do{
            map.put("startPage",pageSize*page++);
            userByLimit = mapper.getUserByLimit(map);
            System.out.println("\n\n第 "+page+" 页的内容如下:\n");
            for (User user : userByLimit) {
                System.out.println(user);
            }
        }while (userByLimit!=null&&userByLimit.size()==pageSize);

    }
}
