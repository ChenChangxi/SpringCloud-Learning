package com.ccx.streamdriver.stream.receivers;

import com.ccx.streamdriver.stream.channels.sink.MyTestSinkOne;
import com.ccx.streamdriver.stream.channels.sink.MyTestSinkTwo;
import com.ccx.streamdriver.stream.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;

/**
 * @program: com.ccx.streamdriver.receivers
 * @description: 测试Spring Integration原生的消息接收机制，ServiceActivator
 * 注解不能够对发送方发送的JSON或者XML进行转化，因此需要Transformer这个注解来进行
 * 转化，然后接收方就可以接收与发送方相同的对象，而不是Object对象。Transformer这
 * 个注解有两个参数，它相当于一个"中转站"，inputchannel接受的是和value参数相同的
 * 输出通道发送的信息，此时它相当于一个receiver，outputchannel参数是发送给value
 * 参数相同的接收通道，此时它相当于是一个sender。
 * @authhor: ChenChangxi
 * @create: 2019-11-24 21:17
 **/

@EnableBinding(value = {MyTestSinkOne.class, MyTestSinkTwo.class})
public class SpringReceiver {

    private static Logger logger = LoggerFactory.getLogger(SpringReceiver.class);

    @ServiceActivator(inputChannel = "input3")
    public void receiveSpring(User user) {
        logger.info("Spring "+"姓名为："+user.getName()+" "+"年龄为："+user.getAge());
    }

    @Transformer(inputChannel = "input1",outputChannel = "output2")
    public User transform(String message) throws Exception{
        logger.info("route to exchange3");
        ObjectMapper objectMapper = new ObjectMapper();
        User user=objectMapper.readValue(message,User.class);
        return user;
    }

    @StreamListener(value = "input2")
    public void receiveModify(User user) {
        logger.info("Modify "+"姓名为："+user.getName()+" "+"年龄为："+user.getAge());
    }
}
