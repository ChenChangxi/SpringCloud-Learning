package com.ccx.streamdriver.stream.channels.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @program: com.ccx.streamdriver.stream.channels.sink
 * @description: 这是定义输入通道的接口，其中定义了很多输入通道，方法需要返回
 * SubscribableChannel对象，它继承于MessageChannel对象，其中封装了一些接收
 * 消息者的一些特性。Input和Output注解的value属性的含义是"主题"，也可以理解为
 * rabbitmq里面的exchange（交换机），而不是对输入和输出通道的bean进行命名，输
 * 入输出通道总是工作在相同的exchange下面，也就是说，只有exchange相同的输入和
 * 输出通道才能够交换信息。
 * @authhor: ChenChangxi
 * @create: 2019-11-24 18:41
 **/

public interface MyTestSinkOne {

    @Input("input1")
    SubscribableChannel input1();

    @Input("input2")
    SubscribableChannel input2();
}
