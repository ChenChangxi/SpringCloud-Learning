package com.ccx.zuulbalance.usercontroller;

import com.ccx.zuulbalance.userservice.UserService;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    *@Param: 我通过以下方法模拟hystrix的请求缓存的功能，并在service层中
     * 打印它是从缓存中获取数据还是正常获取数据，那么我首先执行了两次test1one
     * 和testtwo，可以看到它第一次正常获取，而第二次是从缓存中获取的数据，接着
     * 我清除了缓存中的testone，再次执行testone和testtwo，可以看到testone
     * 正常执行，而testtwo是从缓存中获取的数据，一共正常执行了三次。这里一定要，
     * 注意每次mapping的时候都要初始化hystrix上下文，否则会报错，而初始化了上，
     * 下文，缓存数据就会丢失，因此所有的测试都只能在一个方法中进行。
    *@return: 它的返回是跟服务调用这个请求有关的http信息
    *@Author: ChenChangxi
    *@date: 2019-11-07
    */

    @RequestMapping(value = "/user1")
    public String user1() {
        HystrixRequestContext.initializeContext();
        String testone1=userService.getString1("test1one");
        String testone2=userService.getString1("test1one");
        String testtwo1=userService.getString1("test1two");
        String testtwo2=userService.getString1("test1two");
        String removeone=userService.remove1("test1one");
        String testone=userService.getString1("test1one");
        String testtwo=userService.getString1("test1two");
        return "test1 success";
    }
    @RequestMapping(value = "/user2")
    public String user2() {
        HystrixRequestContext.initializeContext();
        String testone1=userService.getString2("test2one");
        String testone2=userService.getString2("test2one");
        String testtwo1=userService.getString2("test2two");
        String testtwo2=userService.getString2("test2two");
        String removeone=userService.remove2("test2one");
        String testone=userService.getString2("test2one");
        String testtwo=userService.getString2("test2two");
        return "test2 success";
    }
    @RequestMapping(value = "/user3")
    public String user3() {
        HystrixRequestContext.initializeContext();
        String testone1=userService.getString3("test3one");
        String testone2=userService.getString3("test3one");
        String testtwo1=userService.getString3("test3two");
        String testtwo2=userService.getString3("test3two");
        String removeone=userService.remove3("test3one");
        String testone=userService.getString3("test3one");
        String testtwo=userService.getString3("test3two");
        return "test3 success";
    }
    @RequestMapping(value = "/user4")
    public String user4() {
        HystrixRequestContext.initializeContext();
        String testone1=userService.getString4("test4one");
        String testone2=userService.getString4("test4one");
        String testtwo1=userService.getString4("test4two");
        String testtwo2=userService.getString4("test4two");
        String removeone=userService.remove4("test4one");
        String testone=userService.getString4("test4one");
        String testtwo=userService.getString4("test4two");
        return "test4 success";
    }
    @RequestMapping(value = "/user5")
    public String user5() {
        HystrixRequestContext.initializeContext();
        String testone1=userService.getString5("test5one");
        String testone2=userService.getString5("test5one");
        String testtwo1=userService.getString5("test5two");
        String testtwo2=userService.getString5("test5two");
        String removeone=userService.remove5("test5one");
        String testone=userService.getString5("test5one");
        String testtwo=userService.getString5("test5two");
        return "test5 success";
    }
}
