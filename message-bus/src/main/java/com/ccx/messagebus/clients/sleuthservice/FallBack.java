package com.ccx.messagebus.clients.sleuthservice;

import com.ccx.ribbonservice.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: com.ccx.sleuthmonitor.sleuthclients
 * @description: 服务降级处理逻辑
 * @authhor: ChenChangxi
 * @create: 2019-11-27 15:37
 **/

@Component("sleuth-fall-back")
public class FallBack implements SleuthService {

    @Override
    public String feign1() throws Exception {
        return "sleuth-fallback";
    }

    @Override
    public User feign2(@PathVariable("name") String name,
                       @PathVariable("age") Integer age) throws Exception {
        User user=new User();
        user.setName("sleuth fall back");
        user.setAge(505);
        return user;
    }

    @Override
    public String feign3(@PathVariable("name") String name,
                         @PathVariable("age") Integer age) throws Exception {
        return "sleuth-fallback-"+name+"-"+age;
    }
}
