package com.ccx.streamdriver.stream.senders;

import com.ccx.streamdriver.stream.channels.source.MyTestSourceOne;
import com.ccx.streamdriver.stream.channels.source.MyTestSourceTwo;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

/**
 * @program: com.ccx.streamdriver.senders
 * @description: 这是测试Spring Integration原生的消息发送机制，发送时发送
 * 方会以结构化的字符串来发送，比如JSON和XML，这里用的是JSON来发送。
 * @authhor: ChenChangxi
 * @create: 2019-11-24 21:19
 **/


@EnableBinding(value = {MyTestSourceOne.class, MyTestSourceTwo.class})
public class SpringSender {

    @Bean
    @InboundChannelAdapter(value="output1",poller = @Poller(fixedDelay = "10000"))
    public MessageSource<String> send() {
        return () -> new GenericMessage<>("{\"name\":\"ChenChangxi\",\"age\":30}");
    }
}
