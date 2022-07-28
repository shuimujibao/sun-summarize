package juc.cyclicbarrier;

/**
 * 还有其他同步方式， 如CyclicBarrier是基于同步到达某个点的信号量触发机制。
 * CyclicBarrier 从命名上即可知道它是一个可以循环使用（Cyclic）的屏障式（Barrier)
 * 多线程协作方式。采用这种方式进行刚才的安检服务， 就是3个人同时进去，只有3
 * 个人都完成安检，才会放下一批进来。这是一种非常低效的安检方式。但在某种场景
 * 下就是非常正确的方式，假设在机场排队打车时，现场工作人员统一指挥，100量车，每次放3
 * 辆车进来，坐满后开走， 再放下一批车和人进来。通过CyclicBarrier的reset() 来释放
 * 线程资源。
 *
 * @summary Demo
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月28日 10:32:00
 */
public class Demo {
}
