package com.ccx.ribbonservice.testcontroller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: com.ccx.ribbonservice.testcontroller
 * @description: 注册两个微服务，实现客户端的负载均衡
 * @authhor: ChenChangxi
 * @create: 2019-11-07 16:59
 **/


@RestController
public class TestController {

    //log4j的Logger工厂，不要用jdk的
    private final Logger logger=Logger.getLogger(TestController.class);

    //意思是本客户端
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/test")
    public String test() {
        ServiceInstance instance=client.getLocalServiceInstance();
        logger.info("/test,host:"+instance.getHost()+",service_id"+instance.getPort());
        return "Hello World";
    }
}
