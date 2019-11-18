package com.ccx.messagebus.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: com.ccx.messagebus.rabbitmq
 * @description: 这是为了发送消息而创建的映射类
 * @authhor: ChenChangxi
 * @create: 2019-11-17 22:38
 **/

@RestController
public class SendController {

    @Autowired
    private Sender sender;

    @RequestMapping("/send/{message}")
    public String send(@PathVariable("message") String message) {
        sender.send(message);
        return "success";
    }
}
