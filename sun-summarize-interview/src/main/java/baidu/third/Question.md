RocketMq如何保证消息不丢失
-----
分别从Producer发送机制、Broker的持久化机制，以及消费者的offSet机制来最大程度保证消息不易丢失

* 从Producer的视角来看：如果消息未能正确的存储在MQ中，或者消费者未能正确的消费到这条消息，都是消息丢失。
* 从Broker的视角来看：如果消息已经存在Broker里面了，如何保证不会丢失呢（宕机、磁盘崩溃）
* 从Consumer的视角来看：如果消息已经完成持久化了，但是Consumer取了，但是未消费成功且没有反馈，就是消息丢失

##### 从Producer分析：如何确保消息正确的发送到了Broker?

* 默认情况下，可以通过同步的方式阻塞式的发送，check SendStatus，状态是OK，表示消息一定成功的投递到了Broker，状态超时或者失败，
则会触发默认的2次重试。此方法的发送结果，可能Broker存储成功了，也可能没成功

* 采取事务消息的投递方式，并不能保证消息100%投递成功到了Broker，但是如果消息发送Ack失败的话，此消息会存储在CommitLog当中，
但是对ConsumerQueue是不可见的。可以在日志中查看到这条异常的消息，严格意义上来讲，也并没有完全丢失

* RocketMQ支持 日志的索引，如果一条消息发送之后超时，也可以通过查询日志的API，来check是否在Broker存储成功

##### 从Broker分析：如果确保接收到的消息不会丢失?
* 消息支持持久化到Commitlog里面，即使宕机后重启，未消费的消息也是可以加载出来的
* Broker自身支持同步刷盘、异步刷盘的策略，可以保证接收到的消息一定存储在本地的内存中
* Broker集群支持 1主N从的策略，支持同步复制和异步复制的方式，同步复制可以保证即使Master 磁盘崩溃，消息仍然不会丢失

##### 从Cunmser分析：如何确保拉取到的消息被成功消费？
* Consumer自身维护一个持久化的offset（对应MessageQueue里面的min offset），标记已经成功消费或者已经成功发回到broker的消息下标
* 如果Consumer消费失败，那么它会把这个消息发回给Broker，发回成功后，再更新自己的offset
* 如果Consumer消费失败，发回给broker时，broker挂掉了，那么Consumer会定时重试这个操作
* 如果Consumer和broker一起挂了，消息也不会丢失，因为consumer 里面的offset是定时持久化的，重启之后，继续拉取offset之前的消息到本地

[Mysql如何保证数据不丢](https://note.youdao.com/s/aT1Xntc2)
--------
简单来说就是依靠redo log和binlog保证持久化到磁盘后就可以保证，异常重启数据可以正常恢复；这里主要说下这两个log的写入机制。

redolog undolog binlog 顺序

在数据库系统中，redo log、undo log和binlog是三种不同的日志，它们的主要目的和应用场景如下：

* redo log（重做日志）：
  * 用于确保事务的持久性。
  * 在事务提交后，先写入redo log，并且保证redo log写入后，事务才被认为已经提交。
  * redo log记录的是数据页的物理修改，用于恢复提交后的物理数据页(data page)。
* undo log（撤销日志）：
  * 用于保证事务的原子性和一致性。
  * 当事务执行时，会先在undo log中记录数据的旧图像，
  * 如果事务执行过程中发生错误或者回滚，可以通过undo log来回滚到事务开始之前的状态。
* binlog（二进制日志）：
  * 也称作binary log，用于复制和数据恢复
  * 。binlog记录了所有影响数据库数据的语句，但不包括SELECT、SELECT . . . INTO等不修改数据的语句，以及没有改变的语句。
  * binlog是以事件的形式记录，包含了足够的信息去重建在主库或者任何从库执行的语句。

在数据库操作中，这三种日志的写入顺序通常是这样的：

* 事务开始。
* 在undo log中记录事务开始前的状态。
* 修改数据页，生成redo log。
* 记录binlog日志。
* 事务提交，redo log写入提交状态。
* binlog可能也会在此时同步到磁盘。

>这个顺序保证了即使在数据库崩溃的情况下，也能够通过redo log来恢复未写入binlog的已提交事务，然后通过binlog来进行数据同步和恢复。

Mysql都有哪些锁及其对应的实现，哪些是默认加的
--------

[MySql索引的存储结构](https://note.youdao.com/s/68jlHhTy)
--------
B+树

Redis缓存的淘汰策略
-------

什么样的场景ThreadLocal会发生内存泄漏
--------

spring如何解决bean的循环依赖问题
------
* 一级缓存：用于存放完全初始化好的 bean
* 二级缓存：存放原始的 bean 对象（尚未填充属性），用于解决循环依赖
* 三级级缓存：存放 bean 工厂对象，用于解决循环依赖

> bean 的获取过程：先从一级获取，失败再从二级、三级里面获取
  >>创建中状态：是指对象已经 new 出来了但是所有的属性均为 null 等待被 init


* A 创建过程中需要 B，于是 A 将自己放到三级缓里面 ，去实例化 B
* B 实例化的时候发现需要 A，于是 B 先查一级缓存，没有，再查二级缓存，还是没有，再查三级缓存，找到了！
* 然后把三级缓存里面的这个 A 放到二级缓存里面，并删除三级缓存里面的 A
* B顺利初始化完毕，将自己放到一级缓存里面（此时B里面的A依然是创建中状态）
* 然后回来接着创建 A，此时 B 已经创建结束，直接从一级缓存里面拿到 B ，然后完成创建，并将自己放到一级缓存里面

SpringBoot如何实现Stater
---

[JVM的内存结构 ，每一部分都存了什么](/baidu/second/Question.md#jvm分区 )
-------

JVM的优化方式
-----

G1垃圾回收器的回收过程
------

[Synchronized与ReentrantLock实现原理与区别](/didi/first/Question.md#3重量级锁与reentrantlock的区别锁变化的过程-共享锁与独占锁的实现轻量级锁为什么自璇)
-----

redis中的大key如何处理
----

[缓存穿透，缓存击穿，缓存雪崩的解决方案](/jingdong/third/Question.md/#六如何使用redis的存热点数据如何避免缓存击穿)
-----

[布隆过滤器](/jingdong/third/QuestionExtend.md)
----

[线程的状态有哪些](https://www.itheima.com/news/20221107/102713.html)
-----





