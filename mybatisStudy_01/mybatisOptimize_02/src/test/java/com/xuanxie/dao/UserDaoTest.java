package com.xuanxie.dao;

import com.xuanxie.pojo.User;
import com.xuanxie.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.xuanxie.dao.UserMapper;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    @Test
    public void getAllUser(){
        //获得SqlSession对象,其实相当于以前的statement对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一:*************************************
        //执行sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //相当于自己帮我们实现了一个接口实现类并返回
        //接下来可以使用该对象执行方法

        List<User> userList = mapper.getUserList();

        //方式二:**************************************
        List<User> userList1=sqlSession.selectList("com.xuanxie.dao.UserMapper.getUserList");

        //输出结果
        System.out.println(userList);
        System.out.println("***************************");
        for (User user : userList) {
            System.out.println(user);
        }
        System.out.println("************************************");
        System.out.println(userList1);

        //关闭连接
        sqlSession.close();

    }

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

    /*注意增删改需要提交事物,否则操作无效*/
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int count =mapper.addUser2(new User(4,"小明","123456"));

            /* 判断是否成功,是否提交事物*/
            System.out.println(count);
            if(count==1){
                sqlSession.commit();
                System.out.println("事物执行成功!");
            }else{
                System.out.println("事物失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("事物失败");
        }finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }


    }

    @Test
    public void updataUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int count = mapper.updataUser(new User(4, "小丽", "123456"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int count = mapper.deleteUser(4);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updataUserWithMap(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map =new HashMap<>();
        map.put("userid",4);
        map.put("username","李明");
        map.put("userpwd","123456");
        int count = mapper.addUser2(map);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getUsersLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUsersLike("%李%");
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();

    }

}
