package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: springcloud_parent
 * @description:
 * @author: xiaokaixin
 * @create: 2021-11-29 12:41
 **/
@SpringBootApplication
@EnableDiscoveryClient //代表服务注册中心客户端 consul client
//@EnableCircuitBreaker //开启断路器
// @EnableHystrix//开启断路器
@EnableFeignClients
public class OpenFeignHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignHystrixApplication.class,args);
    }
}
