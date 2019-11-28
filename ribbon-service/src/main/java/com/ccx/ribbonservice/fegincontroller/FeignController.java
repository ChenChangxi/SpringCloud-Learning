package com.ccx.ribbonservice.fegincontroller;

import com.ccx.ribbonservice.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @program: com.ccx.ribbonservice.fegincontroller
 * @description: 这是ribbon的客户端，这里我模拟了ribbon客户端请求重试
 * 和hystrix服务熔断的功能，我在这里让线程休眠4000ms，而ribbon客户端设
 * 置的最大请求时间为3000ms，所以ribbon会重试，那么重试了几次之后超过了
 * hystrix服务熔断的最大时间10000ms，会进行服务的熔断和降级。
 * @authhor: ChenChangxi
 * @create: 2019-11-26 17:21
 **/

@RestController
public class FeignController implements BaseController {

    private static Logger logger = LoggerFactory.getLogger(FeignController.class);

    private Integer sleep=4000;

    public void thread() throws Exception{
        Thread.sleep(sleep);
        logger.info("==========sleep:"+sleep+"s==========");
    }

    @Override
    public String feign() throws Exception {
//        thread();
        return "ribbon";
    }

    @Override
    public User feign(@RequestParam("name") String name,
                      @RequestParam("age") Integer age) throws Exception {
//        thread();
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @Override
    public String feign(@RequestBody User user) throws Exception {
//        thread();
        return "ribbon-"+user.getAge()+"-"+user.getName();
    }
}
