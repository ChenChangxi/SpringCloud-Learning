//package com.ccx.sleuthmonitor.streamreceivers;
//
//import com.ccx.streamdriver.stream.channels.processor.MyTestProcessor;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.rxjava.EnableRxJavaProcessor;
//import org.springframework.cloud.stream.annotation.rxjava.RxJavaProcessor;
//import org.springframework.context.annotation.Bean;
//
///**
// * @program: com.ccx.streamdriver.stream.receivers
// * @description: 通过Java的响应式编程来实现消息的输入与输出，下面的写法
// * 可能并不常见，这是Java8新增的语法糖lambda表达式，基本格式为：(x)->{return x}
// * 其中参数可有可无，没有的话用括号代替，后面可以是一个代码块，其中必须有return
// * 语句，如果不是代码块的话可以没有return语句（与python不同）。lambda表达式有
// * 两种主要的用法（下面全体现了），第一是替代匿名内部类，比如下面的代码其实是:
// * return new RxJavaProcessor {
// *     public Observable<O> process(Observable<I> input) {
// *         TODO:TODO:TODO:TODO:TODO:TODO:TODO:TODO:TODO:TODO
// *     }
// * }
// * 第二是结合Stream进行函数式编程，Stream也是Java8新增的，他就相当于是一个迭代器
// * 不过它和迭代器的区别在于它能在迭代的同时做一些事情（filter和map），filter和map
// * 都支持用函数作为参数（既然是函数，当然支持lambda表达式），这点和python和C++是
// * 相同的，它的意思是对流中的每一个元素都当作是一个参数传入map定义的函数中，然后返回
// * 值输入到流中（这在下面也有体现）。除此之外，它是一个"并行流"，迭代器是串行的。
// * @authhor: ChenChangxi
// * @create: 2019-11-25 16:45
// **/
//
//@EnableRxJavaProcessor
//public class RXJavaImp {
//
//    private static Logger logger = LoggerFactory.getLogger(RXJavaImp.class);
//
//    /**
//    *@Description: 这里用到了RxJava编程，也就是响应式编程，他用到了一个观察者的设计模式
//     * 就是说消息通道就好像是被观察者（observable），而我需要定一个观察者来时刻观察着消息
//     * 通道，一旦有消息进入事件发生，立马执行响应函数，来处理消息。那么下面定义的RxJavaProcessor
//     * 中的process方法就是处理消息的函数，它接收从input通道输入的observable对象，同时向
//     * output通道中发送一个observable对象，注意，我通过读源码发现我们无法自己定义通道，必须
//     * 使用input和output通道，那么我们可以通过反向绑定input和output的destination（相同
//     * 应用的output和input的destination不同，不同应用的相同。
//    *@Param: null
//    *@return: RxJavaProcessor
//    *@Author: ChenChangxi
//    *@date: 2019-11-25
//    */
//
//    @Bean
//    public RxJavaProcessor<String,String> process() {
//        return inputStream -> inputStream.map(data -> {
//            logger.info(data);
//            return data;
//        }).map(data -> String.valueOf(data+"-transfer")).buffer(5).map(data -> data+"yes");
//    }
//}
