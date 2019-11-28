package com.ccx.messagebus.sleuthcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: com.ccx.sleuthmonitor.sleuthcontroller
 * @description: 这是该微服务Controller的接口，该微服务的Controller实现
 * 这个接口，然后调用这个微服务的"客户端"的feign必须继承这个接口，实现代码的复用。
 * @authhor: ChenChangxi
 * @create: 2019-11-27 15:29
 **/

public interface BaseController {

    @RequestMapping("/trace2")
    public String traceFeginRibbon() throws Exception;

    @RequestMapping("/trace1")
    public String traceRibbon() throws Exception;
}
