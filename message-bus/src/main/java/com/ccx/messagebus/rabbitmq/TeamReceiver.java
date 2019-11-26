package com.ccx.messagebus.rabbitmq;

import com.ccx.streamdriver.stream.channels.sink.MyTestSinkOne;
import com.ccx.streamdriver.stream.channels.sink.MyTestSinkTwo;
import com.ccx.streamdriver.stream.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @program: com.ccx.sleuthmonitor.streamreceivers
 * @description: 这是为了测试消息组和消息分区而创建的接收者，我设置了消息
 * 分组，input1,2,3,4这四个接收通道同属于service消费组，当发送方发送消息
 * 时，可以在控制台看到，这时四个通道虽然有着相同的destination，但他们不会
 * 全部接收消息，而是通过轮询的方式来接收消息
 * @authhor: ChenChangxi
 * @create: 2019-11-25 22:56
 **/

@EnableBinding(value = {MyTestSinkOne.class, MyTestSinkTwo.class})
public class TeamReceiver {

    private static Logger logger= LoggerFactory.getLogger(TeamReceiver.class);

    @StreamListener("input2")
    public void receive1(User user) {
        logger.info("input2 received name:"+user.getName()+" "+"age:"+user.getAge());
    }
}
