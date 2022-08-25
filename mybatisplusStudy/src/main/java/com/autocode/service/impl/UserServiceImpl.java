package com.autocode.service.impl;

import com.autocode.pojo.User;
import com.autocode.mapper.UserMapper;
import com.autocode.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuanxie
 * @since 2022-08-24
 */
@Service
public class UserServiceImpl
        extends ServiceImpl<UserMapper, User> implements IUserService {

}
