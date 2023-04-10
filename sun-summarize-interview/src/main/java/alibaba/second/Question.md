spring的bean的生命周期
-----------

spring的bean生命周期其实最核心的分为4个步骤，只要理清三个关键的步骤，其他的只是在这三个细节中添加不同的细节实现

>实例化和初始化的区别：  
>实例化是在jvm的堆中创建了这个对象实例，此时它只是一个空的对象，所有的属性为null。
>而初始化的过程就是讲对象依赖的一些属性进行赋值之后，调用某些方法来开启一些默认加载。
>比如spring中配置的数据库属性Bean，在初始化的时候就会将这些属性填充，比如driver、jdbcurl等,然后初始化连接

* **实例化 Instantiation**
  AbstractAutowireCapableBeanFactory.doCreateBean中会调用createBeanInstance()方法,该阶段主要是从beanDefinitionMap循环读取bean,获取它的属性，
  然后利用反射(core包下有ReflectionUtil会先强行将构造方法setAccessible(true))读取对象的构造方法(spring会自动判断是否是有参数还是无参数，以及构造方法中的参数是否可用),
  然后再去创建实例（newInstance）
* **初始化**  
  > 主要包括两个步骤,一个是属性填充，另一个就是具体的初始化过程
  - 属性赋值  
  PopulateBean()会对bean的依赖属性进行填充，@AutoWired注解注入的属性就发生这个阶段，假如我们的bean有很多依赖的对象，那么spring会依次调用这些依赖的对象进行实例化，
  注意这里可能会有循环依赖的问题。后面我们会讲到spring是如何解决循环依赖的问题
  - 初始化 Initialization  
  初始化的过程包括将初始化好的bean放入到spring的缓存中、填充我们预设的属性进一步做后置处理等
* **使用和销毁 Destruction**  
  在Spring将所有的bean都初始化好之后，我们的业务系统就可以调用了。而销毁主要的操作是销毁bean，主要是伴随着spring容器的关闭，此时会将spring的bean移除容器之中。
  此后spring的生命周期到这一步彻底结束，不再接受spring的管理和约束。

spring的BeanPostProcessor处理器
------------
>spring的另一个强大之处就是允许开发者自定义扩展bean的初始化过程，最主要的实现思路就是通过BeanPostProcessor来实现的,spring有各种前置和后置处理器，
>些处理器渗透在bean创建的前前后后,穿插在spring生命周期的各个阶段，每一步都会影响着spring的bean加载过程。接下来我们就来分析具体的过程：

* 实例化阶段  
  该阶段会调用对象的空构造方法进行对象的实例化，在进行实例化之后，会调用InstantiationAwareBeanPostProcessor的postProcessBeforeInstantiation方法
  BeanPostProcessor(具体实现是InstantiationAwareBeanPostProcessor). postProcessBeforeInstantiation();这个阶段允许在Bean进行实例化之前，允许开发者自定义逻辑，
  如返回一个代理对象。不过需要注意的是假如在这个阶段返回了一个不为null的实例，spring就会中断后续的过程。BeanPostProcessor.postProcessAfterInstantiation(); 
  这个阶段是Bean实例化完毕后执行的后处理操作，所有在初始化逻辑、装配逻辑之前执行
* 初始化阶段
  - BeanPostProcessor.postProcessBeforeInitialization该方法在bean初始化方法前被调用，Spring AOP的底层处理也是通过实现BeanPostProcessor来执行代理逻辑的
  - InitializingBean.afterPropertiesSet自定义属性值 该方法允许我们进行对对象中的属性进行设置，假如在某些业务中，一个对象的某些属性为null,但是不能显示为null，
    比如显示0或者其他的固定数值，我们就可以在这个方法实现中将null值转换为特定的值
  - BeanPostProcessor.postProcessAfterInitialization(Object bean, String beanName)可以在这个方法中进行bean的实例化之后的处理，
    比如我们的自定义注解，对依赖对象的版本控制自动路由切换。比如有一个服务依赖了两种版本的实现，我们如何实现自动切换呢？这时候可以自定义一个路由注解,假如叫@RouteAnnotaion，
    然后实现BeanPostProcessor接口，在其中通过反射拿到自定义的注解@RouteAnnotaion再进行路由规则的设定。
  - SmartInitializingSingleton.afterSingletonsInstantiated
* 容器启动运行阶段  
   SmartLifecycle.start容器正式渲染完毕，开始启动阶段,bean已经在spring容器的管理下,程序可以随时调用
* 容器停止销毁  
  - SmartLifecycle.stop(Runnable callback)  spring容器停止运行
  - DisposableBean.destroy() spring会将所有的bean销毁,实现的bean实例被销毁的时候释放资源被调用

FactoryBean和BeanFactory的区别？
----------
* BeanFactory是个bean 工厂类接口，是负责生产和管理bean的工厂，是IOC容器最底层和基础的接口，spring用它来管理和装配普通bean的IOC容器,它有多种实现，
比如AnnotationConfigApplicationContext、XmlWebApplicationContext等。  
* FactoryBean是FactoryBean属于spring的一个bean，在IOC容器的基础上给Bean的实现加上了一个简单工厂模式和装饰模式，是一个可以生产对象和装饰对象的工厂bean，
由spring管理，生产的对象是由getObject()方法决定的。注意：它是泛型的，只能固定生产某一类对象，而不像BeanFactory那样可以生产多种类型的Bean。
在对于某些特殊的Bean的处理中，比如Bean本身就是一个工厂，那么在其进行单独的实例化操作逻辑中，可能我们并不想走spring的那一套逻辑，此时就可以实现FactoryBean接口自己控制逻辑。

spring如何解决循环依赖问题
---------
>循环依赖问题就是A->B->A，spring在创建A的时候,发现需要依赖B,因为去创建B实例,发现B又依赖于A,又去创建A,
>因为形成一个闭环，无法停止下来就可能会导致cpu计算飙升

如何解决这个问题呢？

spring解决这个问题主要靠巧妙的三层缓存，所谓的缓存主要是指这三个map,
* singletonObjects主要存放的是单例对象，属于第一级缓存；
* singletonFactories属于单例工厂对象，属于第三级缓存；
* earlySingletonObjects属于第二级缓存;

>如何理解early这个标识呢？它表示只是经过了实例化尚未初始化的对象。  

* Spring首先从singletonObjects（一级缓存）中尝试获取，如果获取不到并且对象在创建中，则尝试从earlySingletonObjects(二级缓存)中获取，
* 如果还是获取不到并且允许从singletonFactories通过getObject获取，则通过singletonFactory.getObject()(三级缓存)获取。
* 如果获取到了则移除对应的singletonFactory,将singletonObject放入到earlySingletonObjects，其实就是将三级缓存提升到二级缓存,这个就是缓存升级。
* spring在进行对象创建的时候，会依次从一级、二级、三级缓存中寻找对象，如果找到直接返回。
* 由于是初次创建，只能从第三级缓存中找到(实例化阶段放入进去的)，创建完实例，然后将缓存放到第一级缓存中。下次循环依赖的再直接从一级缓存中就可以拿到实例对象了。

jvm宕机解决办法
--------
* 进程闪退
  JVM发生内部崩溃，必然会生成"hs_err_pid"开头的文件。这一般是因为 Xmx 设置过大，超过系统可用内存，JVM 申请内存失败。
  解决方案
  减少Xmx值使得所有的综合不超过服务器物理内存
  调整 Xms=Xmx
  服务器不要运行其他不必要的东西
  配置一部分swap空间（虚拟内存）

* 外部终止
  如果找不到"hs_err_pid"开头的文件，那么这个进程的闪退必然是被从外部终止的。
  1. OOMKiller
  java长期内存占用过高，系统需要内存使用的时候没有内存，Linux的oomkiller机制会干掉最低优先级的内存
  检查 /var/logs/message ， /var/logs/dmesg或者对应日期文件，看看有没有类似下面的内容，日志有时间可以判断
  2. SSH注销
  检查/var/log/auth.log，/var/log/secure或者对应日期的文件，检查宕机的时间点有没有
  时间吻合，那么宕机原因即可确认。
  解决方案
  使用nohup命令在后台运行启动程序，检查ssh注销原因
  3. 其他人为因素
  不是很好判断，需要给shell加上操作记录
* 线程锁死或者无限等待
  表现
  系统无法访问时，当前cpu占用非常低
  使用jstack命令输出线程堆栈即可
  jstack pid >> 1.txt
  or
  jstack -F pid >> 1.txt
  都行,或者用jprofiler工具看堆栈，或者其他任何可以拿到堆栈的工具都可以， java的堆栈就是java方法调用http://的路径，可以定位一些简单的问题

* 内存溢出
  现象
  CPU全部占满，内存达到配置Xmx最大值
  
  总结
  宕机分析的目的就是要找到占用内存的东西，把他找出来，找出他的原因，然后把它改掉。JVM的内存对象分配相当于一颗树，所有的对象都被层层引用，
  直到GCRoot根节点，如果没有根节点的引用，这个对象是完全可以直接释放掉的，大部分也是因为gcRoot存在的对象过多导致的宕机，
  当然也不排除可以使用已经回收的对象来分析，由于生成dump的时间不精确，可能他生成的时候 ，对应的大组件已经回收了
  ，但是jvm缓过来还需要一些时间，所以还是处于大量gc的状态，这时候只能通过对于引用的检索找到最多的引用对象来进行分析。

aop的使用
-------
生产问题的解决方案mq堆积
-------

