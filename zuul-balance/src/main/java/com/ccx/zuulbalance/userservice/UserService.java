package com.ccx.zuulbalance.userservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @program: com.ccx.zuulbalance.userservice
 * @description: 这是服务层，对服务层添加容错保护机制
 * @authhor: ChenChangxi
 * @create: 2019-11-08 13:07
 **/

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    /**
    *@Description: 以下四个方法模拟hystrix的线程隔离，他们都处于
     * 各自的线程池，我们通过配置文件来指定每个线程池中线程的数量，
     * 这里要注意，hystrix默认每个command执行时间超过1000ms会自动
     * 进行服务降级，所以也要通过配置文件指定时间的配置值
    *@Param:
    *@return:
    *@Author: ChenChangxi
    *@date: 2019-11-08
    */
    @HystrixCommand(fallbackMethod = "fail1",commandKey = "getString1",
            groupKey = "group1",threadPoolKey = "pool1")
    public String getString1() {
        try {
            Thread.sleep(15000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restTemplate.getForEntity("http://RIBBON-SERVICE/test1",String.class).getBody();
    }
    @HystrixCommand(fallbackMethod = "fail2",commandKey = "getString2",
            groupKey = "group1",threadPoolKey = "pool1")
    public String getString2() {
        try {
            Thread.sleep(15000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restTemplate.getForEntity("http://RIBBON-SERVICE/test2",String.class).getBody();
    }
    @HystrixCommand(fallbackMethod = "fail3",commandKey = "getString3",
            groupKey = "group1",threadPoolKey = "pool2")
    public String getString3() {
        try {
            Thread.sleep(15000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restTemplate.getForEntity("http://RIBBON-SERVICE/test3",String.class).getBody();
    }
    @HystrixCommand(fallbackMethod = "fail4",commandKey = "getString4",
            groupKey = "group2",threadPoolKey = "pool2")
    public String getString4() {
        try {
            Thread.sleep(15000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restTemplate.getForEntity("http://RIBBON-SERVICE/test4",String.class).getBody();
    }
    @HystrixCommand(fallbackMethod = "fail5",commandKey = "getString5",
            groupKey = "group2",threadPoolKey = "pool2")
    public String getString5() {
        try {
            Thread.sleep(15000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restTemplate.getForEntity("http://RIBBON-SERVICE/test5",String.class).getBody();
    }

    public String fail1() {
        return "execute error1!!";
    }
    public String fail2() {
        return "execute error2!!";
    }
    public String fail3() {
        return "execute error3!!";
    }
    public String fail4() {
        return "execute error4!!";
    }
    public String fail5() {
        return "execute error5!!";
    }
}
