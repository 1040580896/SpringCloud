package com.baizhi.feignclient;

import com.baizhi.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author xiaokaixin
 * @Date 2021/11/26 13:44
 * @Version 1.0
 */
//调用商品服务的接口
@FeignClient(value = "PRODUCT")  //value：用来书写调用服务的id
public interface ProductClient {



    //声明调用商品服务根据类别id查询分页查询商品信息 以及总条数
    @GetMapping("/productList")
     String findByCategoryIdAndPage(@RequestParam("page") Integer page,@RequestParam("rows") Integer rows,@RequestParam("categoryId") Integer categoryId);


    ///声明调用商品服务根据类别id查询一组商品信息
    @GetMapping("/products")
    List<Product> findByCategoryId(@RequestParam("categoryId") Integer categoryId);

    //声明调用根据id查询商品信息接口
    @GetMapping("/product/{id}")
    Product product(@PathVariable("id") Integer id);

    //声明调用商品服务中心test4接口，传递一个list集合类型参数
    @GetMapping("/test4")
    String test4(@RequestParam("ids") String[] ids);

    //声明调用商品服务test3接口，传递一个数组类型 queryString /test3?ids=21&ids=22
    @GetMapping("/test3")
    String test3(@RequestParam("ids") String[] ids);

    //声明调用服务中test2的接口 传递一个商品对象
    @PostMapping("/test2")
    String test2(@RequestBody Product product);

    //定义一个接受零散类型参数接口  路径传递参数
    //声明调用商品服务中test1接口 路径传递数据
    @GetMapping("/test1/{id}/{name}")
    String test1(@PathVariable("id") Integer id,@PathVariable("name") String name);

    //声明调用商品服务中test接口传递name，age
    @GetMapping("/test")
    String test(@RequestParam("name") String name,@RequestParam("age") Integer age);

    //调用商品服务
    @GetMapping("/product")
    String product();

    @GetMapping("/list")
    String list();
}
