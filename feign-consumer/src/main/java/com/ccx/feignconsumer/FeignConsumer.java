package com.ccx.feignconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class FeignConsumer {

    @Bean
    public MySampler sampler() {
        return new MySampler(true);
    }
    /**
     *@Description: 链路收集的策略，在生成bean的时候可以向构造函数中传入收集的
     * 策略，比如span的tag，每一个span都会检验这个tag，如果有这个tag，则收集，
     * 没有则不收集。在这里，我设置成了每一个链路都收集。
     *@Param:
     *@return:
     *@Author: ChenChangxi
     *@date: 2019-11-28
     */
    public class MySampler implements Sampler {

        private Boolean collect;

        public MySampler(Boolean collect) {
            this.collect=collect;
        }

        @Override
        public boolean isSampled(Span span) {
            return true;
        }
    }


    public static void main(String[] args) {
        SpringApplication.run(FeignConsumer.class, args);
    }
}
