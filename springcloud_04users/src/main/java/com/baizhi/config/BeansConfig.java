package com.baizhi.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springcloud_parent
 * @description:
 * @author: xiaokaixin
 * @create: 2021-11-25 15:07
 **/
@Configuration  //代表这是一个springboot 配置类  spring.xml  工厂  创建对象  bean  id  class="xxxx"
public class BeansConfig {

    //工厂中创建RestTemplate
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
