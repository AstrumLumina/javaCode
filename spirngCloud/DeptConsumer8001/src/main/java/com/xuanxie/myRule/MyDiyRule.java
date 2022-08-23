package com.xuanxie.myRule;


import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/*自定义的 负载均衡策略不能放在与启动类同级目录下,防止被扫描到,导致错误*/
public class MyDiyRule extends AbstractLoadBalancerRule {

    /*自定义算法*/
    // 每个服务，访问5次，访问完5次，换下一个服务（假设服务有3个）
    // 每个服务的访问次数，total = 0，默认为0，如果=5，则指向下一个服务节点
    // 当前提供的服务下标，currentIndex = 0，默认0，如果total = 5，则total重置为0，index+1，

    private int total = 0;// 被调用的次数
    private int currentIndex = 0; // 当前是谁在提供服务
    private IClientConfig iClientConfig;

    // @edu.umd.cs.findbugs.annotations.SuppressWarnings(value = "RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE")
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        List<Server> upList = lb.getReachableServers(); // 获取还活着的服务
        List<Server> allList = lb.getAllServers(); // 获取全部的服务

        int serverCount = allList.size();
        if (serverCount == 0) {
            return null;
        }

        if((total++)==5){
            currentIndex++;
        }
        server=upList.get(currentIndex<=upList.size()?currentIndex:0);

        total/=5;
        currentIndex/=serverCount;
        return server;
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub
        this.iClientConfig=clientConfig;
    }


}
