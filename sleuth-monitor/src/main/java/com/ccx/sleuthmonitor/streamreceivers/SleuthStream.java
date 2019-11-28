package com.ccx.sleuthmonitor.streamreceivers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @program: com.ccx.sleuthmonitor
 * @description: 这是为了监听客户端的数据是否输入到了sleuth交换机
 * @authhor: ChenChangxi
 * @create: 2019-11-28 18:06
 **/

@EnableBinding(Sink.class)
public class SleuthStream {

    private static Logger logger= LoggerFactory.getLogger(SleuthStream.class);

    @StreamListener(Sink.INPUT)
    public void receive(String message) {
        logger.info("=========Received:"+message+"==========");
    }
}
