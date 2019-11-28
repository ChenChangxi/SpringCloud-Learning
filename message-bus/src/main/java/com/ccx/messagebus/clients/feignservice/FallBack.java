package com.ccx.messagebus.clients.feignservice;

import com.ccx.ribbonservice.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: com.ccx.feignconsumer.feignservice
 * @description: 这是Hystrix服务熔断后的降级逻辑，它实现FeignClient接口
 * 并重写其中的方法来作为其服务降级后的逻辑。
 * @authhor: ChenChangxi
 * @create: 2019-11-27 11:16
 **/

@Component("feign-fall-back")
public class FallBack implements FeignService {

    @Override
    public String feign() throws Exception {
        return "feign-fallback";
    }

    @Override
    public User feign(@RequestParam("name") String name,
                      @RequestParam("age") Integer age) {
        User user = new User();
        user.setName("feign fall back");
        user.setAge(600000);
        return user;
    }

    @Override
    public String feign(@RequestBody User user) {
        return "feign-fallback-"+user.getName()+"-"+user.getAge();
    }
}
