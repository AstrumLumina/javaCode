package com.xuanxie.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)  //可以使用链式写法
public class Dept implements Serializable {//蓄力化
    private  Long deptid; //主键
    private String deptname;
    private String db_source;
    public Dept(String deptname){
        this.deptname=deptname;
    }
}
