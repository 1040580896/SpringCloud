package com.baizhi.feignclients;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @program: springcloud_parent
 * @description:
 * @author: xiaokaixin
 * @create: 2021-11-29 14:50
 **/

//  自定义HystrixClient的默认备选处理
@Configuration
public class HystrixClientFallback implements HystrixClient{

    @Override
    public String demo(Integer id) {
        return "当前服务不可用，请稍后再试!id"+id;
    }
}
