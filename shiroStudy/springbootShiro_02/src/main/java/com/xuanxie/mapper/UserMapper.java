package com.xuanxie.mapper;

import com.xuanxie.pojo.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public Users getUserById(int id);
    public String getPwdByName(String name);
    public List<Users> getUsersByName(String name);
}
