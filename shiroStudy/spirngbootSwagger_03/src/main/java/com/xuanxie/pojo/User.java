package com.xuanxie.pojo;

//api文档注解测试
/*
@Api(tags = "xxx模块说明")
@ApiOperation("接口说明")
@ApiModel("实体类说明")
@ApiModelProperty("实体类的字段属性说明")
@ApiParam("作用在参数、方法和字段")
* */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户类")
public class User {
    @ApiModelProperty("用户名")
    private  String name;
    @ApiModelProperty("用户年龄")
    private  int age;

}

