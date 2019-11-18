package com.ccx.messagebus.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: com.ccx.messagebus.rabbitmq
 * @description: 这是消息队列的消息生产者
 * @authhor: ChenChangxi
 * @create: 2019-11-17 20:33
 **/

@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String message) {
        System.out.println(message);
        amqpTemplate.convertAndSend("queue",message);
    }
}
