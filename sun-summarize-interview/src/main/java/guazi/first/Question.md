1.bio nio aio区别
-----
2.Rector模型
-----
3.Synchronized  与 ReentrantLock 区别
-----
* Lock是一个接口，而synchronized是Java中的关键字，synchronized是内置的语言实现；     
* synchronized在发生异常时，会自动释放线程占有的锁，因此不会导致死锁现象发生；而Lock在发生异常时，如果没有主动通过unLock()去释放锁，则很可能造成死锁现象，因此使用Lock时需要在finally块中释放锁；   
* Lock可以让等待锁的线程响应中断，而synchronized却不行，使用synchronized时，等待的线程会一直等待下去，不能够响应中断；   
* 通过Lock可以知道有没有成功获取锁，而synchronized却无法办到。   
* Lock可以提高多个线程进行读操作的效率。（可以通过readwritelock实现读写分离）   
* 性能上来说，在资源竞争不激烈的情形下，Lock性能稍微比synchronized差点（编译程序通常会尽可能的进行优化synchronized）。但是当同步非常激烈的时候，synchronized的性能一下子能下降好几十倍。而ReentrantLock确还能维持常态。   
  
4.Synchronized的实现与优化
-----
5.ReentrantLock的实现与优化
-----
6.如何判断链表成环
----

7.JVM的内存区域
-----
8.虚拟机栈都存什么了
-----
9.哪些对象可以作为GCRoot的根
-----
10.线程池的五种状态
-----
11.核心参数的设置
-----
12.阻塞队列的选择
-----
13.拒绝策略的选择
-----
