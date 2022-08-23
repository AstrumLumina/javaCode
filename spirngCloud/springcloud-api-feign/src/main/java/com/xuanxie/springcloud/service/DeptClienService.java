package com.xuanxie.springcloud.service;

import com.xuanxie.springcloud.pojo.Dept;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*Caused by: java.lang.IllegalStateException: Incompatible fallbackFactory instance. Fallback/fallbackFactory of type class com.xuanxie.springcloud.service.DeptServiceHystrixFallbackFacto is not assignable to interface feign.hystrix.FallbackFactory for feign client DEPT-PROVIDER
	at org.springframework.cloud.openfeign.HystrixTargeter.getFromContext(HystrixTargeter.java:88) ~[spring-cloud-openfeign-core-2.2.9.RELEASE.jar:2.2.9.RELEASE]
	at org.springframework.cloud.openfeign.HystrixTargeter.targetWithFallbackFactory(HystrixTargeter.java:63) ~[spring-cloud-openfeign-core-2.2.9.RELEASE.jar:2.2.9.RELEASE]
	at org.springframework.cloud.openfeign.HystrixTargeter.target(HystrixTargeter.java:53) ~[spring-cloud-openfeign-core-2.2.9.RELEASE.jar:2.2.9.RELEASE]
	at org.springframework.cloud.openfeign.FeignClientFactoryBean.loadBalance(FeignClientFactoryBean.java:352) ~[spring-cloud-openfeign-core-2.2.9.RELEASE.jar:2.2.9.RELEASE]
	at org.springframework.cloud.openfeign.FeignClientFactoryBean.getTarget(FeignClientFactoryBean.java:388) ~[spring-cloud-openfeign-core-2.2.9.RELEASE.jar:2.2.9.RELEASE]
	at org.springframework.cloud.openfeign.FeignClientFactoryBean.getObject(FeignClientFactoryBean.java:361) ~[spring-cloud-openfeign-core-2.2.9.RELEASE.jar:2.2.9.RELEASE]
	at org.springframework.cloud.openfeign.FeignClientsRegistrar.lambda$registerFeignClient$0(FeignClientsRegistrar.java:246) ~[spring-cloud-openfeign-core-2.2.9.RELEASE.jar:2.2.9.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.obtainFromSupplier(AbstractAutowireCapableBeanFactory.java:1235) ~[spring-beans-5.2.15.RELEASE.jar:5.2.15.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1177) ~[spring-beans-5.2.15.RELEASE.jar:5.2.15.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:556) ~[spring-beans-5.2.15.RELEASE.jar:5.2.15.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:516) ~[spring-beans-5.2.15.RELEASE.jar:5.2.15.RELEASE]

导错了包,熔断需要导入

*/



// @FeignClient ：为服务客户端注解，value：指定为服务的名字，这样就可以使Feign客户端直接找到对应的微服务
//org.springframework.cloud.openfeign.FeignClient @FeignClient(name = "DEPT-PROVIDER"), 使用feign封装resttemplate

/*
fallback类型时 对应回调应该是实现实现service接口 ，重写方法
fallbackFactory类型时 对应回调应该是实现FallbackFactory<service>接口,重写方法
*/
//@FeignClient(name = "DEPT-PROVIDER",fallback = DeptServiceCallback.class)  //指定服务降级的处理工厂
@FeignClient(name = "DEPT-PROVIDER",fallbackFactory=DeptServiceFallbackFactory.class)  //这个注解可以和上面哪个注解转换
public interface DeptClienService {
    @RequestMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept);

    @RequestMapping("/dept/deptById/{deptId}")
    public Dept deptById(@PathVariable("deptId") int deptId);
    /*
    PathVariable annotation was empty on param 0.
	at feign.Util.checkState(Util.java:129) ~[feign-core-10.12.jar:na]:

	在FeignClient中@PathVariable的value值必须设置
	*/


    @RequestMapping("/dept/allDepts")
    public List<Dept> getAllDept();

    @RequestMapping("/dept/update")
    public boolean updateDept(@RequestBody Dept dept);

    @RequestMapping("/dept/delDept/{deptId}")
    public boolean delDeptById(@PathVariable("deptId") int deptId);
}
