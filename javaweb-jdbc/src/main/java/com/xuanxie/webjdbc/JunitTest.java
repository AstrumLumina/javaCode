package com.xuanxie.webjdbc;

import  org.junit.Test;

public class JunitTest {
/*使用junit 单元测试依赖,
在任意方法前加上@test后
则可像main方法一样运行,且不需要创建此对象,直接测试*/
    @Test
    public  void test(){
        System.out.println("测试开始");
        try{
            int a=1/1;
            int b=1/0;
        }catch (Throwable e){
            e.printStackTrace();
            System.out.println("测试失败,该程序出现错误!");
        }

        System.out.println("测试成功!");
    }
}
