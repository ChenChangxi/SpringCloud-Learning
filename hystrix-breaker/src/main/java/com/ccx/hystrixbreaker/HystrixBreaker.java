package com.ccx.hystrixbreaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class HystrixBreaker {

    @Bean
    @LoadBalanced
    public RestTemplate inject() {
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(HystrixBreaker.class, args);
    }
}
