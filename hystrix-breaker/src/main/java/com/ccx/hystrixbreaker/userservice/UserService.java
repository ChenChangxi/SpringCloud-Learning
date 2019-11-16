package com.ccx.hystrixbreaker.userservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

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

    @CacheRemove(commandKey = "getString1")
    @HystrixCommand(fallbackMethod = "fail1")
    public String remove1(@CacheKey String remove) {
        return "remove1cache";
    }
    
    /**
    *@Description: 完成了hystrix的最后一个重要功能，请求合并功能，它
     * 能将客户端若干请求合并一个请求，从而向向其他微服务发起调用，可以
     * 大大减轻服务器的负担，不过代价是服务端代码要为合并后的请求编写特
     * 定的处理程序。我们在控制层调用batch方法，它在合并后交给处理batch
     * 的方法，对这些请求进行统一处理。这里要注意Future类的用法，它装饰
     * 了你要返回的对象，使之成为一个"异步"对象，如果同步处理，是不会出
     * 现请求合并的效果的，最后调用get方法得到你包装的类，这里要特别注意
     * 如果你一开始调用get方法，它会阻塞其他进程直到这个线程完成调用，这
     * 也就起不到我们想要达到的异步效果，所以get方法一定要最后调用。
    *@Param: 
    *@return: 
    *@Author: ChenChangxi
    *@date: 2019-11-09
    */

    @HystrixCollapser(batchMethod = "getString2",collapserProperties =
        @HystrixProperty(name = "timerDelayInMilliseconds",value = "100"
        )
    )
    public Future<String> batch2(String test) {
        return null;
    }

    @HystrixCommand(fallbackMethod = "fail2",commandKey = "getString2",
            groupKey = "group1",threadPoolKey = "pool1")
    public List<String> getString2(List<String> tests) {
        System.out.println(tests.toString());
        return restTemplate.getForEntity("http://RIBBON-SERVICE/test2/{1}",List.class,StringUtils.join(tests,",")).getBody();
    }

    @HystrixCommand(fallbackMethod = "fail3",commandKey = "getString3",
            groupKey = "group1",threadPoolKey = "pool2")
    public String getString3(String test) {
        try {
            Thread.sleep(15000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restTemplate.getForEntity("http://RIBBON-SERVICE/test3/{1}",String.class,test).getBody();
    }

    @HystrixCommand(fallbackMethod = "fail4",commandKey = "getString4",
            groupKey = "group2",threadPoolKey = "pool2")
    public String getString4(String test) {
        try {
            Thread.sleep(15000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restTemplate.getForEntity("http://RIBBON-SERVICE/test4/{1}",String.class,test).getBody();
    }

    @HystrixCommand(fallbackMethod = "fail5",commandKey = "getString5",
            groupKey = "group2",threadPoolKey = "pool2")
    public String getString5(String test) {
        try {
            Thread.sleep(15000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restTemplate.getForEntity("http://RIBBON-SERVICE/test5/{1}",String.class,test).getBody();
    }

    public String fail1(String test) {
        return "execute error1!!";
    }

    public List<String> fail2(List<String> tests) {
        List<String> results = new ArrayList<String>();
        for(String test : tests) {
            results.add(test+" "+"fail");
        }
        return results;
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
