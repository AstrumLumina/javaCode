package com.xuanxie.springdata_03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MysqlController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询数据库的所有信息,没有定义实体类,用map获取
    @RequestMapping("/getAllUsers")
    public List<Map<String,Object>> getAllUsers(){
        String sql="select * from mybatisstudy.users";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
        return maps;
    }

    @RequestMapping("/addUser/{id}")
    public String addUser(@PathVariable("id")int id){
        System.out.println("debuge===>进入到了adduser方法,参数为 "+id);

        String sql="insert into mybatisstudy.users(id, name, pwd) VALUE (?,?,?)";
        Object[] params=new Object[3];
        params[0]=id;
        params[1]="鑫诚";
        params[2]="123456";
        int update = jdbcTemplate.update(sql, params);
        if(update!=1){
            return "新增失败";
        }
        return "新增成功";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id")int id){
        String sql="delete from mybatisstudy.users where id=?";
        int update = jdbcTemplate.update(sql, id);
        if(update!=1){
            return "删除失败";
        }
        return "删除成功";
    }

    @RequestMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id")int id){
        String sql="update mybatisstudy.users set name='新名字' where id="+id;
        int update = jdbcTemplate.update(sql);
        if(update!=1){
            return "修改失败";
        }
        return "修改成功";
    }

}
