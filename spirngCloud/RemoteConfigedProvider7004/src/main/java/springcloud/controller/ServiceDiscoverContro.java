package springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceDiscoverContro {
    @Autowired
    private DiscoveryClient clientDiscover;
    //通过该对象,可以获得注册到注册中心的一些微服务的信息

    //该处留下接口,用于获取一些微服务的信息
    @RequestMapping("/provider7001/dept/discover")
    public Object discoverClient(){//
        //获取服务列表的微服务清单
        List<String> services = clientDiscover.getServices();
        System.out.println("===========\ndebuge==>"+services);

        //获取某一个具体的微服务
        List<ServiceInstance> serviceInstances=
                clientDiscover.getInstances("DEPT-PROVIDER-7001");//服务实例的id
        for (ServiceInstance instance : serviceInstances) {
            System.out.println(
                    "Host:"+instance.getHost()+ "\n"+
                    "port:"+instance.getPort()+ "\n"+
                    "uri:"+instance.getUri()+ "\n"+
                    "serverid:"+instance.getServiceId()
            );
        }
        return clientDiscover;
    }
}
