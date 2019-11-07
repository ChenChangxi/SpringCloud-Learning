package com.ccx.ribbonservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RibbonService {

    public static void main(String[] args) {
        SpringApplication.run(RibbonService.class, args);
    }

}
