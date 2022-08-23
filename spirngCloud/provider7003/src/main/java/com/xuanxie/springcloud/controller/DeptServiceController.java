package com.xuanxie.springcloud.controller;

import com.xuanxie.springcloud.pojo.Dept;
import com.xuanxie.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptServiceController {
    @Autowired
    private DeptService deptService;

    @RequestMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }

    @RequestMapping("/dept/deptById/{deptId}")
    public Dept deptById(@PathVariable int deptId) {
        return deptService.deptById(deptId);
    }

    @RequestMapping("/dept/allDepts")
    public List<Dept> getAllDept() {
        return deptService.getAllDept();
    }

    @RequestMapping("/dept/update")
    public boolean updateDept(@RequestBody Dept dept) {
        return deptService.updateDept(dept);
    }

    @RequestMapping("/dept/delDept/{deptId}")
    public boolean delDeptById(@PathVariable int deptId) {
        return deptService.delDeptById(deptId);
    }

}
