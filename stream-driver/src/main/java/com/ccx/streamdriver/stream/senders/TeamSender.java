package com.ccx.streamdriver.stream.senders;

import com.ccx.streamdriver.stream.channels.source.MyTestSourceOne;
import com.ccx.streamdriver.stream.entity.User;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.util.Random;

/**
 * @program: com.ccx.streamdriver.stream.senders
 * @description: 这是为了测试消息组与消息分区而创建的类，首先不设置消息组，
 * 将输入通道和输出通道的destination指定相同，那么sender在向output中输出
 * 消息时，我们可以通过控制台看到，所有的input通道都能接收到消息。
 * @authhor: ChenChangxi
 * @create: 2019-11-25 22:55
 **/

@EnableBinding(MyTestSourceOne.class)
public class TeamSender {

    private Random rand = new Random();

    @Bean
    @InboundChannelAdapter(value = "output1",poller = @Poller(fixedDelay = "5000"))
    public MessageSource<User> send() {
        User user = new User();
        user.setAge(rand.nextInt(10));
        user.setName("ChenChangxi");
        return () -> new GenericMessage<User>(user);
    }
}
