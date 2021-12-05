package com.baizhi.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: springcloud_parent
 * @description:
 * @author: xiaokaixin
 * @create: 2021-11-29 14:41
 **/
@FeignClient(value = "HYSTRIX",fallback = HystrixClientFallback.class) //fallback:当这个属性用来指定当前调用服务不可用时，默认的备选出来
public interface HystrixClient {

    @GetMapping("/demo")
    String demo(@RequestParam("id") Integer id);

}
