package com.xuanxie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuanxie.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

}
