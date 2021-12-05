package com.baizhi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud_parent
 * @description:
 * @author: xiaokaixin
 * @create: 2021-11-25 08:42
 **/
@RestController
public class OrderController {

    @Value("${server.port}")
    private int port;

    @GetMapping("/order")
    public String demo(){
        System.out.println("order demo .....");
        return "order demo ok!!!,当前提供服务的端口为:"+port;
    }
}
