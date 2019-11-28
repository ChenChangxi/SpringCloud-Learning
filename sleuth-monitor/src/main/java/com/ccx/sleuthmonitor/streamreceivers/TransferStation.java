package com.ccx.sleuthmonitor.streamreceivers;

import com.ccx.streamdriver.stream.channels.processor.MyTestProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * @program: com.ccx.streamdriver.stream.receivers
 * @description: 这是消息接收的中转站，接收到消息后会返回给消息的
 * 发送者，因为同时涉及消息的发送和接收，因此需要绑定Processor接口
 * 它里面同时定义了发送通道和接收通道。消息的两端（也就是发送消息方
 * 和接收消息方）分别定义在不同的应用中，因此StreamListener可以在
 * 两个应用中监听同一个通道，注意在同一个应用中StreamListener是不能
 * 够监听同一个通道的。
 * @authhor: ChenChangxi
 * @create: 2019-11-24 22:41
 **/


@EnableBinding(MyTestProcessor.class)
public class TransferStation {

    private static Logger logger = LoggerFactory.getLogger(TransferStation.class);

    @StreamListener("input6")
    @SendTo("output5")
    public String receiveAndSend(String message) {
        logger.info("now in transfer station");
        return message+"-transfer";
    }
}
