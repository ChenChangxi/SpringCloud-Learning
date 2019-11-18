package com.ccx.messagebus.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: com.ccx.messagebus.rabbitmq
 * @description: 这是消息队列的配置类，用来配置Queue，Exchange，Router等消息队列的核心实现
 * @authhor: ChenChangxi
 * @create: 2019-11-17 20:34
 **/

@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue() {
        return new Queue("queue");
    }
}
