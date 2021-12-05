package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: springcloud_parent
 * @description:
 * @author: xiaokaixin
 * @create: 2021-11-23 13:51
 **/
@SpringBootApplication
@EnableEurekaServer  //开启当前应用是一个服务注册中心
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class,args);
    }
}
