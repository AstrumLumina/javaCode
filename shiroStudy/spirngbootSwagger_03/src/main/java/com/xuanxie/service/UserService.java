package com.xuanxie.service;

import com.xuanxie.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

public interface UserService {
    @ApiOperation("放回查询到的用户")
    User getUser(@ApiParam("传入一个用户,含有部分信息,依据此此部分信息自动查询补全该用户信息") User user);
}
