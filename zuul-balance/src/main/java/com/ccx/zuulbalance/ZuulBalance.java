package com.ccx.zuulbalance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class ZuulBalance {

    @Bean
    @LoadBalanced
    public RestTemplate inject() {
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(ZuulBalance.class, args);
    }
}
