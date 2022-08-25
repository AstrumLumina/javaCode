package com.xuanxie.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@MapperScan("com.xuanxie.mapper")
@EnableTransactionManagement //开启事务支持
public class MybatisplusConfig {

    /*
    * 配置乐观锁
    * */
//    @Bean //版本升级后该配置方法不生效了
//    public OptimisticLockerInnerInterceptor optimisticLockerInterceptor (){
//        return new  OptimisticLockerInnerInterceptor();
//    }


    //版本更新后,很多都要按这样配置了
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
       //配置乐观锁
        mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        //   配置分页插件
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        //现在逻辑删除主键只要在实体类上用注解,在在配置文件中配好即可,不在需要配置插件
        return mybatisPlusInterceptor;
    }




    /*
    * 配置sql语句执行效率分析插件,并指定只在开发环境下生效
    * 新版不用这么配置,只要导入p6spy依赖,并在配置文件中配置好即可
    * */
//    public PerformanceMonitorInterceptor performanceMonitorInterceptor(){
//        PerformanceMonitorInterceptor performanceMonitorInterceptor = new PerformanceMonitorInterceptor();
//        performanceMonitorInterceptor.setMaxTime(100); //ms 设置sql执行的最大时间，如果超过了则不执行
//        performanceMonitorInterceptor.setFormat(true);
//        return performanceMonitorInterceptor;
//    }
}
