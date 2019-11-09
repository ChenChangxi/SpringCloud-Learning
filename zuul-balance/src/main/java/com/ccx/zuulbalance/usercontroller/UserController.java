package com.ccx.zuulbalance.usercontroller;

import com.ccx.zuulbalance.userservice.UserService;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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
     *@Description: 以下四个方法模拟hystrix的线程隔离，他们都处于
     * 各自的线程池，我们通过配置文件来指定每个线程池中线程的数量，
     * 这里要注意，hystrix默认每个command执行时间超过1000ms会自动
     * 进行服务降级，所以也要通过配置文件指定时间的配置值。我通过线程
     * 休眠的方法来测试线程的分配情况，我为线程池1，2各自分配了2个线
     * 程，有2个请求调用用了线程池1，有3个请求调用用了线程池2，那么
     * 根据hystrix线程隔离以及线程分配的原理，请求1，2，3，4都能正常
     * 执行，并休眠5s，而请求5在到达的时候，由于线程池已经为空，因此
     * 它会进行服务降级，输出回调函数中的内容。
     *@Param:
     *@return:
     *@Author: ChenChangxi
     *@date: 2019-11-08
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
    public String user2() throws InterruptedException, ExecutionException {
        HystrixRequestContext.initializeContext();
        Future<String> result=userService.batch2("one");
        Future<String> result1=userService.batch2("two");
        Future<String> result2=userService.batch2("three");
        Future<String> result3=userService.batch2("four");
        Future<String> result4=userService.batch2("five");
        return result.get()+" "+result1.get()+" "+result2.get()+" "+result3.get()+" "+result4.get();
    }
    @RequestMapping(value = "/user3")
    public String user3() {
        String testone1=userService.getString3("test3one");
        return "test3 success";
    }
    @RequestMapping(value = "/user4")
    public String user4() {
        String testone1=userService.getString4("test4one");
        return "test4 success";
    }
    @RequestMapping(value = "/user5")
    public String user5() {
        String testone1=userService.getString5("test5one");
        return "test5 success";
    }
    
    /**
    *@Description: 
    *@Param: 
    *@return: 
    *@Author: ChenChangxi
    *@date: 2019-11-09
    */
}
