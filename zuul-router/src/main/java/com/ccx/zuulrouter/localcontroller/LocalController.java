package com.ccx.zuulrouter.localcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: com.ccx.zuulrouter.localcontroller
 * @description: 这是为了实现zuul的本地跳转而创建的映射类
 * @authhor: ChenChangxi
 * @create: 2019-11-16 22:19
 **/

@RestController
public class LocalController {

    @RequestMapping("/localurl/application")
    public String local() {
        return "Hello Local Application!!";
    }
}
