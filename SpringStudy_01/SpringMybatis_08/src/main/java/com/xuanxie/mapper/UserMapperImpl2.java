package com.xuanxie.mapper;

import com.xuanxie.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;
import java.util.Map;

/*使用继承方式,
可以直接调用getSqlsession获得sqlsession
以省略sqlsession注入,简化*/
public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper{
    @Override
    public List<User> getUserList() {
        return getSqlSession().getMapper(UserMapper.class).getUserList();
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
    public List<User> getUsersLike(String pattern) {
        return null;
    }
}
