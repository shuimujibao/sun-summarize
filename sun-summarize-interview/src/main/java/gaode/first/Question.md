#### 一、项目介绍
##### 1、重复支付产生原因，解决方案
##### 2、使用业务订单作为分布式的 key,同一笔订单多次支付如何处理
##### 3、系统中面对瞬时流量过大，如何处理，以及对应的数据库设计


#### 二、spring相关
##### 1、ServiceOne类，其对应存在三个bean, serviceA,serviceB,serviceC，此时在ServiceTwo类，使用@Autowired注入serviceA，是否可以成功，解决方案是啥
##### 2、SpringBean初始化中，后置处理器BeanPostProcess与InitializingBean加载顺序是啥-[解读](https://blog.csdn.net/Asa_Prince/article/details/118342171)
##### 3、ServiceOne类，存在构造函数ServiceOne(A,B),ServiceOne(A,C),ServiceOne(B,C),加载bean的时候会使用哪个构造函数

#### 二、redis相关
##### 1、如何保证mysql与数据库的一致性
##### 2、热点key的解决方案-[解读](https://m.jb51.net/article/161499.htm),**重点说明redis服务端的解决方案**

### 三、JDK相关
##### 1、说明可重入锁，公平锁，非公平锁的实现方式，**重点说明非公平锁的竞争过程**
##### 2、ThreadLocal在你项目中的应用，内存泄露产生的原因，是否必须显示移除，ThreadLocal是如何处理的

### 四、RocketMq相关
##### 分析消息丢失的过程，并提出对应的解决方案




