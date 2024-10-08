一、降级和熔断的区别
>‌降级和熔断的主要区别在于触发条件、管理目标层次和实现方式。‌

* ‌触发条件不同‌：
  * 服务熔断一般是某个服务（下游服务）故障引起，而服务降级一般是从整体负荷考虑。
  * 熔断机制通常在检测到某个服务出现问题时触发，如请求失败率超过一定阈值；而降级则是在系统负载过高或资源紧张时，为了保护核心服务而主动降低非核心服务的功能。‌
* ‌管理目标的层次不同‌：
  * 熔断是一个框架级别的处理，每个微服务都需要，没有层次之分；
  * 而降级一般需要对业务有层级之分，通常从最外围服务开始降级。‌
* ‌实现方式不同‌：
  * 熔断机制通常是自动化的，当检测到某个服务出现问题时，自动断开与该服务的交互，等待自我恢复或重新尝试连接；
  * 而降级则是人工控制的，根据系统的整体负载情况，主动关闭或降低非核心服务的功能，以保证核心服务的正常运行。‌45

>综上所述，熔断和降级都是系统自我保护的重要机制，但它们在触发条件、管理目标和实现方式上存在显著差异。熔断主要用于应对单个服务故障，而降级则主要用于应对系统整体负载过高的情况。
