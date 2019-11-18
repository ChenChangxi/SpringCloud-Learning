package com.ccx.messagebus.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: com.ccx.messagebus.rabbitmq
 * @description: 这是消息的接收者
 * @authhor: ChenChangxi
 * @create: 2019-11-17 20:34
 **/

@Component
@RabbitListener(queues = "queue")
public class Receiver {

    @RabbitHandler
    public void receive(String message) {
        System.out.println("receive"+message);
    }
}
