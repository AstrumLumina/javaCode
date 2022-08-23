package com.xuanxie.dao;

import com.xuanxie.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


/*注解开发 实现CRUD*/
public interface UserMapper {//CRUD

    //更加id查询用户
    @Select("select * from mybatisstudy.users where id=#{id}")
    User getUserById(int id);

    @Select("select * from mybatisstudy.users;")
    List<User> getAllUser();

    //方法存在多个参数时,必须使用@paream注解,一个参数时也最好加上,这样符合规范
    //使用@param后,参数依据@param取,而不是更加参数名子取值
    @Select("select * from mybatisstudy.users where name=#{name};")
    User getUserByName(@Param("name") String username);

    @Insert("insert into mybatisstudy.users(id,name,pwd) values(#{id},#{name},#{pwd});")
    int addUser(User user);

    @Update("update users set name=#{name},pwd=#{pwd} where id=#{id};")
    int updateUser(User user);
}
