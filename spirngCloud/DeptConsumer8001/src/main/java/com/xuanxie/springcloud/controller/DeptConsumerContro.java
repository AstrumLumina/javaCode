package com.xuanxie.springcloud.controller;

import com.xuanxie.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerContro {

    @Autowired
    private RestTemplate restTemplate;

    //不适用eureka时写死便于理解
    //private static final String REST_URL_PREFIX="http://localhost:7001";

    //集群后由于同一个服务可能在多个服务器里面都有该服务,不能写死,服务器地址用服务名称(spring.application.name)的大写来代替
    private static final String REST_URL_PREFIX="http://DEPT-PROVIDER";//dept-provider
    /*
     * @loadBalance注解修饰的restTemplate才能实现服务名的调用，
     * * 没有修饰的restTemplate是没有该功能的。原因就是当使用微服务名称的时候，
     * * 可能有多个服务提供者，restTemplate不知道去调用哪个服务提供者，
     * * 只有设置负载均衡之后服务消费者才会去访问某个微服务提供者
     * * ，这个负载均衡的功能我是使用Ribbon提供的*/


    @RequestMapping("/consumer/dept/add")
    public boolean addDept(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,boolean.class);
    }

    @RequestMapping("/consumer/dept/deptById/{deptId}")
    public Dept deptById(@PathVariable int deptId) {
        return  restTemplate.getForObject(REST_URL_PREFIX+"/dept/deptById/"+deptId,Dept.class);
    }
    @RequestMapping("/consumer/dept/allDepts")
    public List<Dept> getAllDept() {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/allDepts",List.class);
    }

    @RequestMapping("/consumer/dept/update")
    public boolean updateDept(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/update",dept,boolean.class);
    }

    @RequestMapping("/consumer/dept/delDept/{deptId}")
    public boolean delDeptById(@PathVariable int deptId) {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/delDept/"+deptId,boolean.class);
    }
}
