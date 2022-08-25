package com.xuanxie.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)

@TableName("user")
public class User {

    @TableId(type = IdType.ASSIGN_ID) //主键生成策略:雪花算法
   // private long id;
    private Long id;
 /*
    设置主键策略后,插入是主键的值一直是0 :
    当idValue为null时,才会走if里面的语句, 但是现在idValue(long类型默认为)为0
    ,因此直接跳过主键策略
    解决方法: 把实体类中的id类型进行封装,变为Long对象类型, 如下
    */
    private String name;
    private int age;
    @TableField("email")  //用于非主键
    private String email;

    //乐观锁
    @Version
    private Integer version;
    //逻辑删除
    @TableLogic
    private int deleted;

    //测试自动填充功能
    @TableField(fill = FieldFill.INSERT)  //再插入时自动填充
    private Date createTime; //mybatis默认开启驼峰命名规则
    @TableField(fill = FieldFill.INSERT_UPDATE)  //在更新和插入时自动填充
    private Date updateTime;


}
