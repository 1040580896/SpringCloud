package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @program: springcloud_parent
 * @description:
 * @author: xiaokaixin
 * @create: 2021-11-29 19:50
 **/
@SpringBootApplication
//@EnableDiscoveryClient  //注意：默认只要引入了discovery client依赖，该注解无须声明 自动注册 consul zk nacos
@EnableHystrixDashboard //开启监控面板
public class HystrixDashBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBoardApplication.class,args);
    }

}
