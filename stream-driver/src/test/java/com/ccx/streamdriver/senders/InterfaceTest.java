package com.ccx.streamdriver.senders;

import com.ccx.streamdriver.StreamDriver;
import com.ccx.streamdriver.stream.channels.source.MyTestSourceOne;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @program: com.ccx
 * @description: 通过注入定义消息通道的接口来实现一个消息发送测试，这里
 * 没有绑定消息的生产者，直接通过向通道中发送消息的方式来进行测试。
 * @authhor: ChenChangxi
 * @create: 2019-11-24 19:00
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StreamDriver.class)
@WebAppConfiguration
public class InterfaceTest {

    @Autowired
    private MyTestSourceOne testSource;

    @Test
    public void send() {
        testSource.output1().send(MessageBuilder.withPayload("from exchange1").build());
    }
}
