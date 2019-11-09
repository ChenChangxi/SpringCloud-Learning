package com.ccx.zuulbalance.userservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
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
    @CacheResult
    @HystrixCommand(fallbackMethod = "fail1",commandKey = "getString1",
            groupKey = "group1",threadPoolKey = "pool1")
    public String getString1(@CacheKey String test) {
        System.out.println("This is not cache1");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restTemplate.getForEntity("http://RIBBON-SERVICE/test1/{1}",String.class,test).getBody();
    }

    @CacheResult
    @HystrixCommand(fallbackMethod = "fail2",commandKey = "getString2",
            groupKey = "group1",threadPoolKey = "pool1")
    public String getString2(@CacheKey String test) {
        System.out.println("This is not cache2");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restTemplate.getForEntity("http://RIBBON-SERVICE/test2/{1}",String.class,test).getBody();
    }

    @CacheResult
    @HystrixCommand(fallbackMethod = "fail3",commandKey = "getString3",
            groupKey = "group1",threadPoolKey = "pool2")
    public String getString3(@CacheKey String test) {
        System.out.println("This is not cache3");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restTemplate.getForEntity("http://RIBBON-SERVICE/test3/{1}",String.class,test).getBody();
    }

    @CacheResult
    @HystrixCommand(fallbackMethod = "fail4",commandKey = "getString4",
            groupKey = "group2",threadPoolKey = "pool2")
    public String getString4(@CacheKey String test) {
        System.out.println("This is not cache4");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restTemplate.getForEntity("http://RIBBON-SERVICE/test4/{1}",String.class,test).getBody();
    }

    @CacheResult
    @HystrixCommand(fallbackMethod = "fail5",commandKey = "getString5",
            groupKey = "group2",threadPoolKey = "pool2")
    public String getString5(@CacheKey String test) {
        System.out.println("This is not cache5");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restTemplate.getForEntity("http://RIBBON-SERVICE/test5/{1}",String.class,test).getBody();
    }

    @CacheRemove(commandKey = "getString1")
    @HystrixCommand(fallbackMethod = "fail1")
    public String remove1(@CacheKey String remove) {
        return "remove1cache";
    }

    @CacheRemove(commandKey = "getString2")
    @HystrixCommand(fallbackMethod = "fail2")
    public String remove2(@CacheKey String remove) {
        return "remove2cache";
    }

    @CacheRemove(commandKey = "getString3")
    @HystrixCommand(fallbackMethod = "fail3")
    public String remove3(@CacheKey String remove) {
        return "remove3cache";
    }

    @CacheRemove(commandKey = "getString4")
    @HystrixCommand(fallbackMethod = "fail4")
    public String remove4(@CacheKey String remove) {
        return "remove4cache";
    }

    @CacheRemove(commandKey = "getString5")
    @HystrixCommand(fallbackMethod = "fail5")
    public String remove5(@CacheKey String remove) {
        return "remove5cache";
    }

    public String fail1(String test) {
        return "execute error1!!";
    }
    public String fail2(String test) {
        return "execute error2!!";
    }
    public String fail3(String test) {
        return "execute error3!!";
    }
    public String fail4(String test) {
        return "execute error4!!";
    }
    public String fail5(String test) {
        return "execute error5!!";
    }
}
