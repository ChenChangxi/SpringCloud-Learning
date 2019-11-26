package com.ccx.streamdriver.stream.channels.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @program: com.ccx.streamdriver.stream.channels
 * @description: 这是定义输出通道的接口，这个接口中定义了很多输出通道
 * @authhor: ChenChangxi
 * @create: 2019-11-24 18:40
 **/

public interface MyTestSourceTwo {

    @Output("output3")
    MessageChannel output3();

    @Output("output4")
    MessageChannel output4();
}
