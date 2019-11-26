package com.ccx.streamdriver.receivers;

import com.ccx.streamdriver.stream.channels.sink.MyTestSinkOne;
import com.ccx.streamdriver.stream.channels.sink.MyTestSinkTwo;
import com.ccx.streamdriver.stream.channels.source.MyTestSourceOne;
import com.ccx.streamdriver.stream.channels.source.MyTestSourceTwo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @program: com.ccx
 * @description: 这是消息的接收者，这里注意，EnableBinding这个注解会为绑定
 * 的接口自动创建bean，我们测试的时候是直接向output通道里面输出信息，不会创建
 * sender的EnableBinding因此要把input和output接口都加进来，来创建bean。
 * @authhor: ChenChangxi
 * @create: 2019-11-24 19:24
 **/

@EnableBinding(value = {MyTestSinkOne.class, MyTestSinkTwo.class, MyTestSourceTwo.class, MyTestSourceOne.class})
public class TestReceiver {

    private static Logger logger = LoggerFactory.getLogger(TestReceiver.class);

    @StreamListener("exchange1")
    public void receive1(Object receive) {
        logger.info("receive "+receive);
    }

    @StreamListener("exchange3")
    public void receive2(Object receive) {
        logger.info("receive "+receive);
    }
}
