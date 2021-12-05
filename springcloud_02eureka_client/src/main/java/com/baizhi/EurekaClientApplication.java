package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: springcloud_parent
 * @description:
 * @author: xiaokaixin
 * @create: 2021-11-23 19:55
 **/
@SpringBootApplication
@EnableEurekaClient   // 让当前微服务作为一个eureka serve客户端 进行服务注册
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class,args);
    }
}
