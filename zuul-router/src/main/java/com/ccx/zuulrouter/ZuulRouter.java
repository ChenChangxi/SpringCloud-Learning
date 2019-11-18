package com.ccx.zuulrouter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class ZuulRouter {

    public static void main(String[] args) {
        SpringApplication.run(ZuulRouter.class, args);
    }

    /**
    *@Description: 这是利用正则表达式自定义路由，因为有些路由有共同的
     * 特点，如果手动配置会有很多重复无效的工作，所以利用Java的正则表达式
     * 来定义一个通用的规则，所有符合这个规则的服务都会自动生成路由。
    *@Param:
    *@return:
    *@Author: ChenChangxi
    *@date: 2019-11-17
    */

    @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {

        return new PatternServiceRouteMapper(
                "(?<name>^.+)-(?<version>v.+$)",
                "${version}/${name}"
        );
    }
}
