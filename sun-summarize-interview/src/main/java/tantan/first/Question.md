1.Redis中zSet、Map、List底层实现原理是什么
------
* zSet中完全是跳跃表实现的么，低容量时，如何做的优化处理
  - zSet用到了3种数据结构，压缩列表、跳表，并且使用哈希表来保存value:score键值对。    
  > 当同时满足下面2个条件时会用到压缩列表，否则会用跳表：
  >  - 集合中元素都小于64字节
  >  - 集合中元素个数小于128个

* Redis中Map实现原理

* zipList数据结构是什么样

2.Redis中发布订阅是如何实现的
------

3.CMS的垃圾回收过程是什么样的 哪些阶段会发生stop word，对应的年轻代选择何种的垃圾回收器
------

4.RocketMq,客户端和Broker维持了哪些心跳
------
- Producer与NameSrv随机建立长连接，定期从NameSrv获取topic路由信息。
- 然后Producer还与Broker的Master结点建立长连接，用于发送消息。
- 此外Producer还与Master维持了一个心跳。
- Consumer与NameSrv随机建立长连接，定期从NameSrv获取topic路由信息。
- 然后Consumer还与Broker的Master和Slave结点建立长连接，用于订阅消息。
- 此外Consumer还与Master和slave维持了一个心跳。   
以上就是RocketMQ所有的心跳机制。

5.RocketMq主要的组成部分有哪些
------
