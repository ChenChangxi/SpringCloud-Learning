package com.ccx.sleuthmonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import zipkin.server.EnableZipkinServer;

/**
 * @program: com.ccx.sleuthmonitor
 * @description: 注意这里有一个超级大坑，当你用http来直接从客户端来收集链路消息
 * 的时候要用EnableZipkinServer这个注解，但当你从消息中间件中收集链路信息的时候
 * 要添加EnableZipkinStreamServer这个注解。
 * @authhor: ChenChangxi
 * @create: 2019-11-28 19:20
 **/


//@EnableZipkinServer
@EnableDiscoveryClient
@SpringBootApplication
@EnableZipkinStreamServer
public class SleuthMonitor {

    public static void main(String[] args) {
        SpringApplication.run(SleuthMonitor.class, args);
    }
}
