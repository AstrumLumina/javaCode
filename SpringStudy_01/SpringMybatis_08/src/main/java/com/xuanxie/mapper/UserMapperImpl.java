package com.xuanxie.mapper;

import com.xuanxie.pojo.User;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;
import java.util.Map;

public class UserMapperImpl implements UserMapper{

    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> getUserList() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        return userList;
    }
    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public int deleteUser(int id) {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int count = mapper.deleteUser(id);
        count=1/0;//制造错误,查看事务
        return count;
    }

    @Override
    public int updataUser(User user) {
        return 0;
    }

    @Override
    public int addUser2(User user) {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int count = mapper.addUser2(user);
        return count;
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
