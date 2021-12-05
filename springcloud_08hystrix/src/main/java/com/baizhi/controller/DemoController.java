package com.baizhi.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud_parent
 * @description:
 * @author: xiaokaixin
 * @create: 2021-11-29 12:43
 **/
@RestController
public class DemoController {

    @GetMapping("/demo")//?id=
    //熔断之后快速响应
    @HystrixCommand(fallbackMethod ="demoFallBack",defaultFallback = "defaultFallBack") //熔断之后的出来
    public String demo(Integer id){
        System.out.println("demo ok!!!");
        if(id<=0){
            throw new RuntimeException("无效id");
        }
        return "demo ok!!!";
    }

    //默认的出来方法
    public String defaultFallBack(){
        return "当前网络连接失败，请重试！！！";
    }

    //自己备选处理
    public String demoFallBack(Integer id){
        return "当前活动过于火爆，服务已经熔断 "+id;
    }
}
