package com.ccx.ribbonservice.entity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: com.ccx.feginconsumer.entity
 * @description: Fegin的继承特性，由于Feign的客户端完全是服务端的一个"副本"
 * 因此可以用继承封装的方法，将共同的逻辑封装在一个接口中。服务端实现这个接口并
 * 重写其中的方法来实现其逻辑，客户端继承这个接口。这里要注意，Java的注解继承不
 * 适用于接口的继承以及类继承后方法的重写，但这里RequestMapping注解显然是被继承
 * 了，这是SpringMVC的特性，而不是Java的特性，这个需要研究一下源码。
 * @authhor: ChenChangxi
 * @create: 2019-11-26 20:53
 **/

public interface BaseController {

    @RequestMapping(value = "/feign",method = RequestMethod.GET)
    public String feign() throws Exception;

    @RequestMapping(value = "/feign_param",method = RequestMethod.GET)
    public User feign(@RequestParam("name") String name,
                      @RequestParam("age") Integer age) throws Exception;

    @RequestMapping(value = "/feign_entity",method = RequestMethod.POST)
    public String feign(@RequestBody User user) throws Exception;
}
