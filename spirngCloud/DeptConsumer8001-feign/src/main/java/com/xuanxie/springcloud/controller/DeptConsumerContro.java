package com.xuanxie.springcloud.controller;

import com.xuanxie.springcloud.pojo.Dept;
import com.xuanxie.springcloud.service.DeptClienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerContro {

    @Autowired
    private DeptClienService deptClienService;//feign对resttemplate进行了封装

    @RequestMapping("/consumer/dept/add")
    public boolean addDept(Dept dept) {
        return deptClienService.addDept(dept);
    }

    @RequestMapping("/consumer/dept/deptById/{deptId}")
    public Dept deptById(@PathVariable int deptId) {
        return deptClienService.deptById(deptId);
    }
    @RequestMapping("/consumer/dept/allDepts")
    public List<Dept> getAllDept() {
        return deptClienService.getAllDept();
    }

    @RequestMapping("/consumer/dept/update")
    public boolean updateDept(Dept dept) {
        return deptClienService.updateDept(dept);
    }

    @RequestMapping("/consumer/dept/delDept/{deptId}")
    public boolean delDeptById(@PathVariable int deptId) {
        return deptClienService.delDeptById(deptId);
    }
}
