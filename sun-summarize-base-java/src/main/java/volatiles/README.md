 volatile关键词的实现原理 - [解读](https://blog.csdn.net/qq_31452291/article/details/119239182)
-------------
* 实现原理
  - 指令级别实现，happen-before原则
  - 读写屏障
* 用在哪里，为什么这么用（不具备原子性、有序性）
  - 保障变量的可见性（i++）
  - 禁止指令重排（单例模式DCL）
 
