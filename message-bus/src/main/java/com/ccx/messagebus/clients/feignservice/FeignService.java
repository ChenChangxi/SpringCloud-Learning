package com.ccx.messagebus.clients.feignservice;

import com.ccx.ribbonservice.fegincontroller.BaseController;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @program: com.ccx.feginconsumer.feginservice
 * @description: 这是fegin客户端，它就相当于是ResTemplate，只不过比那样写更加优雅，
 * 一个FeignClient对应这一个微服务（需要在value中指定），他就相当于是微服务"服务端"
 * 的一个"副本"，里面有所有微服务服务端所提供的对外调用接口，你调用接口中的方法，就相
 * 当于是向微服务发起http调用，这是一个"伪"http调用，因此feign被称为是"声明式服务调用"。
 * @authhor: ChenChangxi
 * @create: 2019-11-26 17:24
 **/


@FeignClient(value = "ribbon-service",fallback = FallBack.class) //永远记住，服务的提供者是server，消费者是client
public interface FeignService extends BaseController {}
