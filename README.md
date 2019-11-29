
# 这是我学SpringCloud的时候写的一些代码

* ## Erueka: 
  > 这是SpringCloud的高可用分布式服务注册中心，是整个
  > 微服务的核心模块，每一个微服务都注册在这里，当集群中的微服务向其他
  > 微服务发起调用时，也是通过它来进行服务发现的

* ## Ribbon:
  > 这是SpringCloud的客户端负载均衡，它是整个微服务最
  > 为核心的模块，所有的服务提供者。我们正是在这个模块中完成业务逻辑的
  > 编写，以及通过它所提供的api与其他服务进行互相调用。它还提供了客户端
  > 的负载均衡功能，这里要注意服务与实例的区别，以及客户端与服务端的区别
  > 服务是在配置文件中所指定的应用名，一个服务对应着很多 实例，我们可以
  > 通过命令行参数为他们指定不同的端口，负载均衡就是在一个服务的不同实例
  > 之间进行的，而客户端是你发起调用的服务，服务端是被调用的服务。
  
* ## Hystrix:
  > 这是SpringCloud的断路器，如果说Eureka承担的是分布式
  > 任务，那么它承担着另一项在集群中非常重要的任务，就是处理亿级高并发请求。
  > 一旦某一个服务器发生故障，或者请求超过了我们自己设置的熔断时间，它会
  > "熔断"服务并进行服务降级处理。它还会将请求分组，并为每个组设置一个线程
  > 池，这样就形成了线程隔离。当面对大量相同请求时，它还会为这些请求设置缓存
  > 功能，从而极大减轻服务器的负担，并能在数据一致性遭到破坏时，自动消除缓存
  > 。它还能够进行请求合并，从而大量的减少线程消耗的数量。这些都是高并发情境下
  > 我们为了"容错"和"减负"所采取的策略。
  
 
* ## Feign:
  > 这是SpringCloud的声明式服务调用模块，它模仿了"客户端"
  > ，"服务器"的模式，也就是C/S模式，而传统的Ribbon是B/S模式。采用这种模式
  > 可以更加优雅的进行服务调用，同时也能简化逻辑。它同时也集成了hystrix模块
  > 同样能进行线程熔断和服务降级的配置。

* ## Zuul: 
  > 这是SpringCloud的网关服务模块，也是边缘服务的一个模块，
  > 它是我们整个微服务应用的"入口"。我们会手动的给它维护一张路由表，我们通过
  > 利用通配符，甚至是Java的正则表达式来自定义一些路由规则，由它来进行转发到
  > 微服务集群内部的某一个微服务上，当然，它和Nginx相比，它不能实现服务端负载
  > 均衡，不过这个差距可以由Ribbon来弥补。它还有一个拦截器的功能，相当于Spring
  > MVC的inceptor，我们的路由规则也是由拦截器来实现的。

* ## Config:
  > 这是SpringCloud的分布式配置中心，它承担着为各个微服务
  > 提供配置文件的作用，每个微服务在启动的时候都会向它请求配置文件，接着它
  > 会向远端git仓库请求配置文件，并存储在本地git仓库中，之后提供给具体的
  > 某一个微服务应用。
  
* ## Stream:
  > 这是SpringCloud的消息驱动服务。所谓中间件，就是独立于
  > 客户端和服务端的组件，它们通常起着"异步"的作用，比如消息队列就是典型的
  > 中间件，我们把消息发给消息队列，接收者可以不用立即接收，于是就起到"异步"
  > 的作用。它可以在整个微服务集群中负责各个微服务之间的异步消息传递，它屏蔽
  > 了不同消息中间件的差异性，提出了"绑定器"与"消息通道"的概念。要注意它和消
  > 息总线的区别，消息总线是专门用来更新配置文件的。

* ## Bus:
  > 这是SpringCloud的消息总线模块，它承担的是配置文件的更新
  > 任务。当配置文件发生更新时，我们向分布式配置中心发送请求，分布式配置中心
  > 将更新消息发送给消息中间件，各个微服务会在消息中间件中收到更新消息，从而
  > 向分布式配置中心请求配置文件。

* ## Sleuth:
  > 这是SpringCloud的链路跟踪服务端，它会将所有对集群中
  > 微服务的各个调用集中保存起来，一次调用可以分为对个请求，一个调用是一
  > 个trace，一次请求是一个span，一个trace中包含多个span，这些信息的处
  > 理有两种方法，第一种是通过http交给这个服务端保存，另一种是通过消息队列
  > 来把信息交给服务端。那么最后还要通过mysql来进行持久化。




