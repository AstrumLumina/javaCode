package com.xuanxie.config;

import com.xuanxie.pojo.Users;
import com.xuanxie.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo
            (PrincipalCollection principalCollection) {
        System.out.println("=====doGetAuthorizationInfo===授权==========");
        //SimpleAuthenticationInfo
        SimpleAuthorizationInfo authenticationInfo = new SimpleAuthorizationInfo();
       //一下权限实际因该放到数据库中,的权限表里
       // authenticationInfo.addStringPermission("user:add");//给经过此函数的所有用户赋予user:add权限
        Subject currentUser = SecurityUtils.getSubject();
        Users  users = (Users) currentUser.getPrincipal();
        authenticationInfo.addStringPermission(users.getPermission());
        return (AuthorizationInfo) authenticationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo
            (AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("====doGetAuthorizationInfo====登录认证==========");
//        //实际应该 从数据库中获取数据 用户名和密码
//        String username="root";
//        String password="123456";
//        UsernamePasswordToken taken=(UsernamePasswordToken)authenticationToken;
//        //验证身份
//        if(taken.getUsername().equals(username)){
//            //密码认证 的工作交由shiro去做,更有利于安全
//           return new SimpleAuthenticationInfo("",password,"");
//        }
//        return null;//没有该用户则返回空,然后抛出异常 UnknownAccountException

        UsernamePasswordToken taken=(UsernamePasswordToken)authenticationToken;
        String paramName=taken.getUsername();
        //数据库 获得用户名 密码
        List<Users> usersByName = userService.getUsersByName(taken.getUsername());
        for (Users users : usersByName) {
            if (users.getName().equals(paramName)){
                //认证是可以传递一些参数,以供后面(授权)使用
                return new SimpleAuthenticationInfo(users,users.getPwd(),"");
            }
        }
        return null;
    }
}
