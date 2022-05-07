1.final的用法
----
作用域：

* final在Java中是一个保留的关键字，可以声明成员变量、方法、类以及本地变量,不可以作用于抽象类和接口。一旦你将引用声明作final，
你将不能改变这个引用了，编译器会检查代码，如果你试图将变量再次初始化的话，编译器会报编译错误。   
* 方法前面加上final关键字，代表这个方法不可以被子类的方法重写
* final方法比非final方法要快，因为在编译的时候已经静态绑定了，不需要在运行时再动态绑定
* final类通常功能是完整的，它们不能被继承
* 在匿名类中所有变量都必须是final变量

好处：
final关键字提高了性能。JVM和Java应用都会缓存final变量。
final变量可以安全的在多线程环境下进行共享，而不需要额外的同步开销。
使用final关键字，JVM会对方法、变量及类进行优化。

2.HashMap实现原理
----

3.Atomic包的实现
----
  Atomic的核心操作就是CAS（compare and set,利用CMPXCHG指令实现，它是一个原子指令）,
  该指令有三个操作数，
  * 变量的内存值V（value的缩写），
  * 变量的当前预期值E（exception的缩写），
  * 变量想要更新的值U（update的缩写），当内存值和当前预期值相同时，将变量的更新值覆盖内存值。

> ABA问题的解决方法 :   
> 每次更新成功，戳值都会发生变化，戳值的设置是由编程人员自己控制的。

4.单例模式
----
饿汉模式  
懒汉模式（线程不安全）  
懒汉模式（线程安全）  
双重检查模式 （DCL）   
静态内部类单例模式   
枚举单例   
使用容器实现单例模式   

5.JVM内存模型
----
* 程序计数器（Program Counter Register）
* Java虚拟机栈（JVM Stacks）
* 本地方法栈（Native Method Stacks）
* Java堆（Heap）
* 方法区（Method Area）
* 运行时常量池（Runtime constant Pool）

6.String a = "a" 存放的位置
----

7.年轻代用的垃圾回收算法
----
复制算法
存活对象较少的情况下比较高效
扫描了整个空间一次（标记存活对象并复制移动）
适用于年轻代（即新生代）：基本上98%的对象是”朝生夕死”的，存活下来的会很少

8.Eden区和Survivor区的比例是8：1：1 什么时候调整这个比例
----
首先优化Minor GC频繁问题。通常情况下，由于新生代空间较小，Eden区很快被填满，就会导致频繁Minor GC，
因此可以通过增大新生代空间来降低Minor GC的频率。例如在相同的内存分配率的前提下，新生代中的Eden区增加一倍，Minor GC的次数就会减少一半。

9.Spring的aop如何实现的
----

Spring AOP中的动态代理主要有两种方式，JDK动态代理和CGLIB动态代理。
----
* JDK动态代理通过反射来接收被代理的类，并且要求被代理的类必须实现一个接口。JDK动态代理的核心是InvocationHandler接口和Proxy类。
如果目标类没有实现接口，那么Spring AOP会选择使用CGLIB来动态代理目标类。
* CGLIB（Code Generation Library），是一个代码生成的类库，可以在运行时动态的生成某个类的子类，
注意，CGLIB是通过继承的方式做的动态代理，因此如果某个类被标记为final，那么它是无法使用CGLIB做动态代理的。


10.Spring的事物如何实现的
----

Spring支持声明式事务，即使用注解来选择需要使用事务的方法，它使用@Transactional注解在方法上表明该方法需要事务支持。这是一个基于AOP的实现操作。

11.SpringMVC 请求过程
----
1.用户发送请求至前端控制器DispatcherServlet  

2.DispatcherServlet收到请求调用处理器映射器HandlerMapping。 
 
3.处理器映射器根据请求url找到具体的处理器，生成处理器执行链HandlerExecutionChain(包括处理器对象和处理器拦截器)一并返回给DispatcherServlet。   

4.DispatcherServlet根据处理器Handler获取处理器适配器HandlerAdapter执行HandlerAdapter处理一系列的操作，如：参数封装，数据格式转换，数据验证等操作   

5.执行处理器Handler(Controller，也叫页面控制器)。   

6.Handler执行完成返回ModelAndView   

7.HandlerAdapter将Handler执行结果ModelAndView返回到DispatcherServlet  

8.DispatcherServlet将ModelAndView传给ViewReslover视图解析器   

9.ViewReslover解析后返回具体View  

10.DispatcherServlet对View进行渲染视图（即将模型数据model填充至视图中）。  

11.DispatcherServlet响应用户。   

12.jstack : 主要用来查看某个Java进程内的线程堆栈信息
----
* jps : 主要用来输出JVM中运行的进程状态信息。
* jmap : 用来查看堆内存使用状况，一般结合jhat使用。

14.查一个进程的占用情况
----
* ps -ef | grep kafka

* top -p 2913


