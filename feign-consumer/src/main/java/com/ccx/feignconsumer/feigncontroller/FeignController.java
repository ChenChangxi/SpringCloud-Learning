package com.ccx.feignconsumer.feigncontroller;

import com.ccx.feignconsumer.feignservice.FeignService;
import com.ccx.ribbonservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: com.ccx.feginconsumer.fegincontroller
 * @description: 这是浏览器访问的controller，是对外提供的接口，它作为微服务
 * 的客户端来向微服务的服务端发起调用请求。
 * @authhor: ChenChangxi
 * @create: 2019-11-26 17:27
 **/

@RestController
public class FeignController implements BaseController{

    @Autowired
    private FeignService feignService;

    @Override
    public String feign1() throws Exception{
        return feignService.feign()+"-fegin";
    }

    @Override
    public User feign2(@PathVariable("name") String name,
                       @PathVariable("age") Integer age) throws Exception{
        return feignService.feign("ChenChangxi",21);
    }

    @Override
    public String feign3(@PathVariable("name") String name,
                         @PathVariable("age") Integer age) throws Exception{
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return feignService.feign(user);
    }
}
