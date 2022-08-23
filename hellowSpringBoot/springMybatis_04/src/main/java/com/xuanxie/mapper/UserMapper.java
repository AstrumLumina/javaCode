package com.xuanxie.mapper;

import com.xuanxie.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper  //这个注解表示这是一个mybatis的mapper类,并将其的实现类转换为接口类后注入到bean中
@Repository  //也可以在主程序中使用注解自动扫描包  @MapperScan("com.xuanxie.mapper")
                // 若有多个实现类先可以指定注入哪个类
public interface UserMapper {

    List<Users> getAllUsers();
    Users getUserById(Integer id);
    int addUser(Users user);
    int deleteUserById(int id);
}
