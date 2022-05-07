1.rocketMq架构图
-----
（一）主要角色    
Message    
代表一条消息，使用messageId唯一识别，用户在发送时可以设置messageKey，便于之后查询和跟踪。
RocketMQ不对消息的格式做限制，message body是二进制，序列化操作由用户完成。

Topic  
topic用于将消息按主题做划分，producer将消息发往指定的topic，consumer订阅该topic就可以收到这条消息。  
Topic跟发送方和消费方都没有强关联关系，发送方可以同时往多个topic投放消息，消费方也可以订阅多个topic的消息。  
在RocketMQ中，topic是一个上逻辑概念。消息存储不会按topic分开。  

Queue   
topic和queue是1对多的关系，一个Topic下可以包含多个Queue，主要用于负载均衡。    
发送消息时，用户只指定topic，producer会根据topic的路由信息选择具体发到哪个Queue上。   
consumer订阅消息时，会根据负载均衡策略决定订阅哪些queue的消息。   
  
Offset   
RocketMQ在存储消息时会为每个topic下的每个Queue生成一个消息的索引文件，   
每个queue都对应一个offset记录当前queue中消息条数。   


（二）RocketMQ的基础架构  

1.NameServer   
NameServer可以看作是RocketMQ的注册中心，它管理两部分数据：集群的Topic-Queue的路由配置；
Broker的实时配置信息。其它模块通过Nameserv提供的接口获取最新的topic配置和路由信息。  

（1）Producer/Consumer ：通过查询接口获取topic对应的Broker的地址信息

（2）Broker ： 注册配置信息到nameserv， 实时更新topic信息到nameserv

2.Broker    
Broker是RocketMQ的核心模块，负责接收并存储消息，同时提供Push/Pull接口来将消息发送给consumer。
Consumer可选择从Master或者Slave读取数据。多个主/从组成Broker集群，集群内的Master节点之间不做数据交互。
Broker同时提供消息查询的功能，可以通过MessageID和messageKey来查询消息。Borker会将自己的topic配置信息实时同步到nameserv。

3.Producer    
消息的发送端，Producer位于用户的进程内，Producer通过NameServ获取所有broker的路由信息，根据负载均衡策略选择将消息发到哪个broker，然后调用broker接口提交消息。

4.Consumer  
消息的消费端，位于用户进程内。Consumer通过向broker发送Pull请求来获取消息数据。
如果consumer在请求时没有数据，Broker可以将请求暂时hold住不返回，等待新消息来的时候再回复，这就是Push模式。
Consumer可以以两种模式启动，广播（Broadcast）和集群（Cluster），广播模式下，一条消息会发送给所有consumer，集群模式下消息只会发送给一个consumer

(三) 高可用  
1、Nameserv的实现非常轻量化，每个服务都是无状态的，缓存了整个集群的全量数据，并且会将数据写入持久化到磁盘，任何一个节点的上线和下线都不影响数据的一致性。   

2、Broker分为主节点和从节点，message的数据都写入master节点，Slave节点从master节点同步数据。因为只有主节点接收数据写入，所以在主节点挂掉后，无法再接收消息，
但是客户端仍然可以从slave读取之前写入的消息。通过将多个主从节点组合成一个集群，可以保证broker的高可用。在一个主节点挂掉后，producer可选择将数据发送到集群内其他主节点    

3、Producer位于用户端，支持失败策略来决定消息优先发到哪个broker，可以及时排除已下线的broker    

4、多个Consumer组成ConsumerGroup，在集群默认下，每个consumer负责消费一部分Queue的消息，当一个consumer下线后，group内的节点会重新做负载均衡，    
保证所有queue的消息都至少有一个consumer节点在消费。

5、Cluster模式下支持消息确认和重发，consumer消费成功后会将状态同步给broker。如果消费失败，broker会将消息重新发送，直到消费成功或者超过重发次数。     

2.网关的好处
-----

3.服务治理的好处
-----

4.rocketMq的一次工作流程
-----
（1）、启动NameServer，NameServer起来后监听端口，等待Broker、Producer、Consumer连上来，相当于一个路由控制中心。

（2）、Broker启动，跟所有的NameServer保持长连接，定时发送心跳包。心跳包中包含当前Broker信息（IP+端口等）以及存储所有Topic信息。注册成功后，NameServer集群中就有Topic跟Broken的映射关系。

（3）、收发消息前，先创建Topic，创建Topic时需要指定该Topic要存储在哪些Broker上，也可以在发送消息时自动创建Topic。

（4）、Producer发送消息，启动时先跟NameServer集群中的其中一台建立长连接，并从NameServer中获取当前发送的Topic存在哪些Broken上，轮询从队列列表中选择一个队列，然后与队列所在的Broker建立长连接从而向Broker发消息。

（5）、Consumer跟Producer类似，跟其中一台NameServer建立长连接，获取当前订阅Topic存在哪些Broker上，然后直接跟Broker建立连接通道，开始消费信息。

5.rocketMq的持久化策略
-----
6.rocketMq如何保证消息不丢失
-----
