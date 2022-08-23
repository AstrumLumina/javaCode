package com.xuanxie.springcloud.service;

import com.xuanxie.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component   //注册到容器中
public class DeptServiceFallbackFactory implements FallbackFactory<DeptClienService>{

    //@HystrixCommand
    @Override
    public DeptClienService create(Throwable cause) {
        return new DeptClienService() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public Dept deptById(int deptId) {
                return new Dept((long)deptId,"服务降级,无法为您提供服务,请稍后再试","");
            }

            @Override
            public List<Dept> getAllDept() {
                Dept dept = new Dept(0L, "服务降级,无法为您提供服务,请稍后再试", "");
                ArrayList<Dept> depts = new ArrayList<>();
                depts.add(dept);
                return depts;
            }

            @Override
            public boolean updateDept(Dept dept) {
                return false;
            }

            @Override
            public boolean delDeptById(int deptId) {
                return false;
            }
        };
    }
}
