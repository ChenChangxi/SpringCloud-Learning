package com.ccx.streamdriver.stream.channels.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * @program: com.ccx.streamdriver.stream.channels
 * @description: 这是定义输出通道的接口，这个接口中定义了很多输出通道，方法
 * 需要返回MessageChannel对象，它定义了很多消息发送者的特性
 * @authhor: ChenChangxi
 * @create: 2019-11-24 18:38
 **/

@Component
public interface MyTestSourceOne {

    @Output("output1")
    MessageChannel output1();

    @Output("output2")
    MessageChannel output2();
}
