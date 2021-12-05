package com.baizhi.controller;

import com.baizhi.feignclients.HystrixClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud_parent
 * @description:
 * @author: xiaokaixin
 * @create: 2021-11-29 14:37
 **/
@RestController
public class TestDemoController {

    //注入openfeign客户端对象
    @Autowired
    private HystrixClient hystrixClient;

    @GetMapping("test")
    public String test(){
        System.out.println("test ok....");
        String demoResult = hystrixClient.demo(-21);
        System.out.println("demo result:"+demoResult);
        return "test ok";
    }
}
