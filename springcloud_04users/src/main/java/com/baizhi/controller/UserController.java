package com.baizhi.controller;

import com.netflix.loadbalancer.IRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @program: springcloud_parent
 * @description:
 * @author: xiaokaixin
 * @create: 2021-11-25 08:43
 **/
@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired  //服务注册与发现客户端对象
    private DiscoveryClient discoveryClient;

    @Autowired  //负载均衡客户端对象
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user")
    public String invokeDemo(){
        log.info("user demo...");
 
        //1.调用订单服务  服务地址：http://localhost:9999/order   接收返回值 接收返回值 String类型
        //RestTemplate restTemplate = new RestTemplate();
        //String orderResult = restTemplate.getForObject("http://localhost:9999/order", String.class);

        //2.实验ribbon组件+RestTemplate实现负载均衡  1. DiscoveryClient  2. LoadBalanceClient   @LoadBalance
        // List<ServiceInstance> serviceInstances = discoveryClient.getInstances("ORDERS");
        //
        // serviceInstances.forEach(serviceInstance -> {
        //     log.info("服务主机:{},服务端口:{},服务地址:{}",serviceInstance.getHost(),serviceInstance.getPort(),serviceInstance.getUri());
        // });
        //log.info("调用订单服务成功:{}",orderResult);

        //String result = new RestTemplate().getForObject(serviceInstances.get(0).getUri() + "/order", String.class);

        //3.使用loadBalancerClient进行服务调用
         //ServiceInstance serviceInstance = loadBalancerClient.choose("ORDERS"); //默认轮询策越
        // log.info("服务地址:{},服务主机:{},服务端口:{}",serviceInstance.getUri(),serviceInstance.getHost(),serviceInstance.getPort());
        // String result = restTemplate.getForObject(serviceInstance.getUri() + "/order", String.class);

        //4.使用@LoadBalanced  作用：可以让对象具有ribbon负载均衡特性
        //IRule rule;
        String result = restTemplate.getForObject("http://ORDERS/order", String.class);
        return "ok"+result;
    }

    //自定义随机策虐
    public String randowHost(){
        List<String> hosts = new ArrayList<>();
        hosts.add("localhost:9999");
        hosts.add("localhost:9990");
        //生成随机数
        int i = new Random().nextInt(hosts.size());
        return hosts.get(i);
    }
}
