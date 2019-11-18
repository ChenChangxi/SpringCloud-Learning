package com.ccx.ribbonservice.configcontroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: com.ccx.ribbonservice.configcontroller
 * @description: 这是作为分布式配置中心的客户端而创建的映射
 * @authhor: ChenChangxi
 * @create: 2019-11-17 14:21
 **/

@RefreshScope
@RestController
public class ConfigController {

    @Value("${from}")
    private String value;

    @RequestMapping("/config")
    public String config() {

        return value;
    }
}
