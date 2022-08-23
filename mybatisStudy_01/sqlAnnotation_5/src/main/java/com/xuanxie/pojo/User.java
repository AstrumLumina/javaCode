package com.xuanxie.pojo;

/*属性名最好更数据库中的一致,否则容易出错(除非使用特殊的map传参进行,则可以随意区属性名)*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*导入lombok后使用@Data自动帮我们生成get set tostring 方法,而不用手写*/
@Data
@AllArgsConstructor/*有参构造*/
@NoArgsConstructor/*无参构造*/
public class User {
    private int id;
    private String name;
    private String pwd;

}
