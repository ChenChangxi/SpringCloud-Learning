package com.ccx.messagebus.clients.sleuthservice;

import com.ccx.feignconsumer.feigncontroller.BaseController;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @program: com.ccx.sleuthmonitor.feginclient
 * @description: 这是为了测试Sleuth服务跟踪而创建的Feign客户端。
 * @authhor: ChenChangxi
 * @create: 2019-11-27 15:09
 **/

@FeignClient(value = "feign-consumer",fallback = FallBack.class)
public interface SleuthService extends BaseController {

}
