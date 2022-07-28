synchronized 作用域
-------

synchronized 的用法：

用在某一个对象上，如：synchronized (this)
用在方法上，如：public synchronized void run() {}
用在类上，如：synchronized (SynchronizeDemo.class) {}、public synchronized static void method() {}

现在有这么几个问题需要注意：

1、 synchronized (this) 表示锁住了当前对象，那么当前对象的其他方法是否可以执行？

可以！当一个线程访问对象的一个 synchronized(this) 同步代码块时，另一个线程仍然可以访问该对象中的非 synchronized(this) 同步代码块。

2、 synchronized (this) 锁住当前对象，自然使用同一个对象再次访问临界区的时候就会阻塞。但是换一个对象访问这个临界区就不会阻塞

3、 public synchronized static void method() {} 这种锁住静态方法的方式其实就是锁住类，即锁住全部的对象，对象之间互斥。当多个对象并发执行此方法时，需要排队。

同理，执行非synchronized 代码块时不会阻塞

4、synchronized 不能继承，父类的 synchronized 方法被子类重写后默认不是 synchronized 的，必须显示指定


* 接口的方法不能加synchronized关键字


* 构造方法不能加synchronized关键字，首先加了编译器会报错，其次new对象的过程采用CAS等方式保证了安全性，无需再次同步
