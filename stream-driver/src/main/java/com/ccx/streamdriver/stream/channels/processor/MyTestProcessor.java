package com.ccx.streamdriver.stream.channels.processor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @program: com.ccx.streamdriver.stream.channels.processor
 * @description: 它同时定义了很多输入和输出通道
 * @authhor: ChenChangxi
 * @create: 2019-11-24 18:51
 **/

public interface MyTestProcessor {

    @Input("input5")
    SubscribableChannel input();

    @Input("input6")
    SubscribableChannel input2();

    @Output("output5")
    MessageChannel output1();

    @Output("output6")
    MessageChannel output2();
}
