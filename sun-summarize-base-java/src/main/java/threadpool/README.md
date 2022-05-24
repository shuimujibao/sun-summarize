 线程池例题
---------------
* 实现原理  
* 用到了哪些设计模式？
* 阻塞队列有哪些，特点是什么？
* 线程池内部抛异常怎么办，如何保证任务不丢
* 线程池中的线程变化过程

线程池的好处
--------
* 降低资源消耗。通过重复利用已创建的线程降低线程创建和销毁造成的消耗。
* 提高响应速度。当任务到达时，任务可以不需要等到线程创建就能立即执行。
* 提高线程的可管理性。线程是稀缺资源，如果无限制的创建，不仅会消耗系统资源，还会降低系统的稳定性，使用线程池可以进行统一的分配，调优和监控。

Executor 框架结构(主要由三大部分组成)
--------

* 任务(Runnable /Callable)
* 任务的执行(Executor)   
  任务执行机制的核心接口 Executor ，以及继承自 Executor 接口的 ExecutorService 接口。
  ThreadPoolExecutor 和 ScheduledThreadPoolExecutor 这两个关键类实现了 ExecutorService 接口。
* 异步计算的结果(Future)
  Future 接口以及 Future 接口的实现类 FutureTask 类都可以代表异步计算的结果。    
  当我们把 Runnable接口 或 Callable 接口 的实现类提交给 ThreadPoolExecutor 或 ScheduledThreadPoolExecutor 执行。（调用 submit() 方法时会返回一个 FutureTask 对象）
