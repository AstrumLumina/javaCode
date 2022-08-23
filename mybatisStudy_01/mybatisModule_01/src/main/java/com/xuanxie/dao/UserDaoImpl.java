package com.xuanxie.dao;

import com.xuanxie.pojo.User;

import java.util.List;
import java.util.Map;

/*该类无作用,只是放到者,方便我们理解mybatis*/
public class UserDaoImpl implements UserDao{
    @Override
    public List<User> getUserList() {
        //这里将进行数据查询操作,并提取出结果,然后放回,较为复杂,且还要考虑数据库连接,断开等操作,代码较多,比较复杂
        return null;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public int deleteUser(int id) {
        return 0;
    }

    @Override
    public int updataUser(User user) {
        return 0;
    }

    @Override
    public int addUser2(User user) {
        return 0;
    }

    @Override
    public int addUser2(Map<String, Object> map) {
        return 0;
    }

    @Override
    public List<User> getUsersLike(String patter) {
        return null;
    }
}
