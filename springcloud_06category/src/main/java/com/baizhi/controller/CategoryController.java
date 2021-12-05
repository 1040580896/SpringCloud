package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Product;
import com.baizhi.feignclient.ProductClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @program: springcloud_parent
 * @description:
 * @author: xiaokaixin
 * @create: 2021-11-26 13:35
 **/
@RestController
public class CategoryController {

    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

    @Value("${server.port}")
    private int port;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/category")
    public String category(){
        log.info("category service,,,,,");
        //1.RestTemplate 2.RestTemplate +Ribbon()  3.OPenFeign
        // String product = productClient.product();
        // String list = productClient.list();
        // log.info("结果1：{}",product);
        // log.info("结果2：{}",list);

        // String result = productClient.test("xiaokaixin", 21);
        //String result = productClient.test1(21,"小开心");
        //String result = productClient.test2(new Product(1,"衣服",23.23,new Date()));
        // productClient.test3(new String[]{"21", "22", "23"})
        // String result = productClient.test4(new String[]{"21", "22", "23"});
        //Product product = productClient.product(21);
        // List<Product> products = productClient.findByCategoryId(1);
        // // log.info("product:{}",products);
        // products.forEach(product->log.info("prduct:{}",products));

        //自定义json反序列化   对象转为json 序列化   on字符串转为对象

        String result = productClient.findByCategoryIdAndPage(1, 5, 1);
        JSONObject jsonObject = JSONObject.parseObject(result);
        System.out.println(jsonObject.get("total"));
        Object rows = jsonObject.get("rows");
        System.out.println(rows);

        //二次json反序列化
        List<Product> products = jsonObject.parseArray(rows.toString(), Product.class);
        products.forEach(product -> {
            log.info("product:{}",product);
        });

        //String result = productClient.product();

        return result;
    }

}
