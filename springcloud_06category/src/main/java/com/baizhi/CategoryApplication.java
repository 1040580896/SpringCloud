package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: springcloud_parent
 * @description:
 * @author: xiaokaixin
 * @create: 2021-11-26 13:28
 **/
@SpringBootApplication
@EnableDiscoveryClient  //开启服务注册
@EnableFeignClients     //开启openFein客户端调用
public class CategoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CategoryApplication.class,args);
    }
}
