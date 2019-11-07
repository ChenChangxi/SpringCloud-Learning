package com.ccx.zuulbalance.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: com.ccx.zuulbalance.usercontroller
 * @description: 它是面向用户的微服务，是用户调用的接口
 * @authhor: ChenChangxi
 * @create: 2019-11-07 17:03
 **/

@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    /**
    *@Description: 这是用户调用的接口
    *@Param: 注意这里在写url的时候访问的是服务名，这是微服务的一个非常重要的特性
    *@return: 它的返回是跟服务调用这个请求有关的http信息
    *@Author: ChenChangxi
    *@date: 2019-11-07
    */
    @RequestMapping(value = "/user")
    public String user() {
        return restTemplate.getForEntity("http://RIBBON-SERVICE/test",String.class).getBody();
    }
}
