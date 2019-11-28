package com.ccx.messagebus.sleuthcontroller;

import com.ccx.messagebus.clients.feignservice.FeignService;
import com.ccx.messagebus.clients.sleuthservice.SleuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: com.ccx.sleuthmonitor.sleuthcontroller
 * @description: 这是为了测试Sleuth请求跟踪服务而创建的测试类。
 * @authhor: ChenChangxi
 * @create: 2019-11-27 15:11
 **/

@RestController
public class SleuthController implements BaseController{

    private static Logger logger = LoggerFactory.getLogger(SleuthController.class);

    @Autowired
    private SleuthService sleuthService;

    @Autowired
    private FeignService feignService;

    @Override
    public String traceRibbon() throws Exception{
        logger.info("========ribbon-sleuth========");
        return feignService.feign()+"-sleuth";
    }

    @Override
    public String traceFeginRibbon() throws Exception{
        logger.info("========ribbon-feign-sleuth========");
        return sleuthService.feign1()+"-sleuth";
    }
}
