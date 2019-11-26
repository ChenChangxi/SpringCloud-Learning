package com.ccx.messagebus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: com.ccx.messagebus
 * @description: 这是为了测试RabbitMQ而创建的，RabbitMQ是一种
 * 非常重要的消息中间件，它包括Broker,Queue,Exchange,Binding,
 * Routing Key,Sender和Receiver组成的，它是为了实现发送与接受
 * 的异步进行而存在的，Sender把消息发给Exchange，Exchange通过
 * Routering Key与Queue进行Binding，然后把Sender的Message发送
 * 给Queue，Queue将消息投递给Receiver，完成消息的传输，这些都是
 * 需要配置的，这个项目只是简单的演示了一下。
 * @authhor: ChenChangxi
 * @create: 2019-11-18 18:52
 **/

@SpringBootApplication
public class MessageBus {

    public static void main(String[] args) {
        SpringApplication.run(MessageBus.class,args);
    }
}
