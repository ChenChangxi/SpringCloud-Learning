package com.ccx.feignconsumer.feigncontroller;

import com.ccx.ribbonservice.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: com.ccx.feignconsumer.feigncontroller
 * @description: 这是该微服务Controller的接口，该微服务的Controller实现
 * 这个接口，然后调用这个微服务的"客户端"的feign必须继承这个接口，实现代码的复用。
 * @authhor: ChenChangxi
 * @create: 2019-11-27 15:24
 **/

public interface BaseController {

    @RequestMapping("/feign")
    public String feign1() throws Exception;

    @RequestMapping("/feign_param/{name}/{age}")
    public User feign2(@PathVariable("name") String name,
                       @PathVariable("age") Integer age) throws Exception;

    @RequestMapping("/feign_entity/{name}/{age}")
    public String feign3(@PathVariable("name") String name,
                         @PathVariable("age") Integer age) throws Exception;
}
