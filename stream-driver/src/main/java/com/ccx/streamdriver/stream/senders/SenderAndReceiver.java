package com.ccx.streamdriver.stream.senders;

import com.ccx.streamdriver.stream.channels.processor.MyTestProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

/**
 * @program: com.ccx.streamdriver.stream.senders
 * @description: 测试消息反馈功能，它可以发送一条消息给接收者，
 * 然后会接收到消息接收者发来的"反馈"。
 * @authhor: ChenChangxi
 * @create: 2019-11-24 22:38
 **/

@EnableBinding(Processor.class)
public class SenderAndReceiver {

    private static Logger logger = LoggerFactory.getLogger(SenderAndReceiver.class);

    @Bean
    @InboundChannelAdapter(value = "output",poller = @Poller(fixedDelay = "5000"))
    public MessageSource<String> send() {
        return () -> new GenericMessage<String>("send");
    }

    @StreamListener(value = "input")
    public void receive(String message) {
        logger.info(message+"-back");
    }
}
