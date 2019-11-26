package com.ccx.streamdriver.stream.channels.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @program: com.ccx.streamdriver.stream.channels.sink
 * @description: 这是输入通道接口，其中定义了很多输入通道
 * @authhor: ChenChangxi
 * @create: 2019-11-24 18:42
 **/

public interface MyTestSinkTwo {

    @Input("input3")
    SubscribableChannel input3();

    @Input("input4")
    SubscribableChannel input4();
}
