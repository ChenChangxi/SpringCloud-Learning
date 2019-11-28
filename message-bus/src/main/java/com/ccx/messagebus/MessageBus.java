package com.ccx.messagebus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

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

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MessageBus {

    @Bean
    public MySampler sampler() {
        return new MySampler(true);
    }
    /**
    *@Description: 链路收集的策略，在生成bean的时候可以向构造函数中传入收集的
     * 策略，比如span的tag，每一个span都会检验这个tag，如果有这个tag，则收集，
     * 没有则不收集。在这里，我设置成了每一个链路都收集。
    *@Param:
    *@return:
    *@Author: ChenChangxi
    *@date: 2019-11-28
    */
    public class MySampler implements Sampler {

        private Boolean collect;

        public MySampler(Boolean collect) {
            this.collect=collect;
        }

        @Override
        public boolean isSampled(Span span) {
            return true;
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(MessageBus.class,args);
    }
}
