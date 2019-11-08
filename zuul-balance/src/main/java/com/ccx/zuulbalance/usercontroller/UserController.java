package com.ccx.zuulbalance.usercontroller;

import com.ccx.zuulbalance.userservice.UserService;
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
    private UserService userService;

    /**
    *@Description: 这是用户调用的接口
    *@Param: 注意这里在写url的时候访问的是服务名，这是微服务的一个非常重要的特性
    *@return: 它的返回是跟服务调用这个请求有关的http信息
    *@Author: ChenChangxi
    *@date: 2019-11-07
    */
    @RequestMapping(value = "/user1")
    public String user1() {
        return userService.getString1();
    }
    @RequestMapping(value = "/user2")
    public String user2() {
        return userService.getString2();
    }
    @RequestMapping(value = "/user3")
    public String user3() {
        return userService.getString3();
    }
    @RequestMapping(value = "/user4")
    public String user4() {
        return userService.getString4();
    }
    @RequestMapping(value = "/user5")
    public String user5() {
        return userService.getString5();
    }
}
