package com.ccx.streamdriver.senders;

import com.ccx.streamdriver.StreamDriver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: com.ccx
 * @description: 这是通过直接注入消息通道来实现一个消息发送测试，消息通道可以指定
 * 名称，因此Spring中相同的实例bean可能会有不同的名称，可以用Qualifier指定是哪个
 * 名称的bean实例。
 * @authhor: ChenChangxi
 * @create: 2019-11-24 19:02
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StreamDriver.class)
public class ChannelTest {

    @Autowired
    @Qualifier("exchange3")
    private MessageChannel messageChannel;

    @Test
    public void send() {
        messageChannel.send(MessageBuilder.withPayload("from output-3").build());
    }
}
