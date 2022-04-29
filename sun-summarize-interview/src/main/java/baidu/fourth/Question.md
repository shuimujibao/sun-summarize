zk单个节点都存储了哪些信息
-------
zk查看一个节点的命令是啥
--------
zk集群选举时集群是否可用，当前节点数为偶数时，是否可以完成选举过程
------
* Zookeeper集群的数量为奇数个
   （注意：这里并不是说偶数个就不行，而是：比如：5台和6台集群的容灾能力是一样的，所以我们可以少用一台达到相同的目的）
* 在ZooKeeper中，有三种角色：Leader，Follower，Observer

    - 一个ZooKeeper集群同一时刻只会有一个Leader，其他都是Follower或Observer。
    - Zookeeper集群中的任何一台机器都可以响应客户端的读操作，且全量数据都存在于内存中，因此Zookeeper更适合以读操作为主的应用场景。
    >注意，当不是leader的服务器收到客户端事务操作，他会将其转发到Leader，让Leader进行处理。
    - ZooKeeper集群的所有机器通过一个Leader选举过程来选定一台被称为『Leader』的机器，Leader服务器为客户端提供读和写服务。
    - Follower和Observer都能提供读服务，不能提供写服务。  
    
 两者唯一的区别在于，Observer机器不参与Leader选举过程，也不参与写操作的『过半写成功』策略，因此Observer可以在不影响写性能的情况下提升集群的读性能。

如何认定zk集群彻底挂掉
-----

创建对象的方式有哪些
--------

dubble基于什么（传输层）协议实现的
-------

dubble的协议选择
------

dubble与feign对比
-------

服务治理的选择
------

spring的bean初始化过程
-----


bean的循环依赖如何解决
----

何时Spring的事物会失效，如何处理
-------

spring获取一个类的代理类有几种方式
-----

jdk动态代理与cglib动态代理的区别,jdk动态代理为什么效率高
----








