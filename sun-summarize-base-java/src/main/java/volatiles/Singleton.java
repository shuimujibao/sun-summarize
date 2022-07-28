package volatiles;

/**
 * 单例模式DCL
 *
 * @summary Singleton
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月28日 15:50:00
 */
public class Singleton {

	/**
	 * 声明对象
	 * ==============
	 * 实例化对象的过程：
	 * 1、分配内存空间
	 * 2、初始化对象
	 * 3、将内存空间地址赋值给对应的引用
	 * <p>
	 * 但是由于操作系统的指令重排序，所以上面的过程可能会变成如下过程：
	 * 1、分配内存空间
	 * 2、将内存空间地址赋值给对应的引用
	 * 3、初始化对象
	 * <p>
	 * 如果是这个流程，多线程环境下就可能将一个未初始化的对象引用暴露出来，从而导致不可预料的结果。
	 * 因此，为了防止这个过程的重排序，我们需要将变量设置为volatile类型的变量。
	 */
	private static volatile Singleton singleton;

	/**
	 * 私有化构造器，禁止外部初始化
	 */
	private Singleton() {
	}

	/**
	 * 获取实例
	 *
	 * <p>
	 * 1. 第一次判断单例对象的引用是否指向null，如果不为null则直接返回singleton，为null则进入下面的同步块实例化新的对象。
	 * 2. 获取Singleton.class对象的对象锁，在多线程的情况下同一时间只有一个线程会获得锁并进入同步块，执行同步块内的代码。
	 * 3. 进入同步块后，在此判断单例对象的引用是否指向null。
	 * ==这里再次判断的意义是：==
	 * 虽然我们在进入同步块前进行了一次判断，但在我们等待获取锁的过程中，其它某个已经获得锁的线程可能已经执行了同步块内的内容，为singleton创建了实例。
	 * 所以在进入同步块后我们需要进行第二次判断，如果本次判断singleton的指向依然为null，那么此时我们确定，只有当前线程在可以改变singleton指向的同步块内，
	 * 且singleton此时的指向为null。那么此时我们可以放心大胆的执行实例化的动作。
	 * 4. 当前线程实例化对象完成并退出同步块，此时其它阻塞在等待锁位置的线程（已经进行了第一次if判断判断结果为true）获得锁并进入同步块，
	 * 进行第二次if检查，发现singleton已经指向了某个实例，不在进行实例化动作
	 *
	 * @return Singleton 实例
	 */
	public Singleton getInstance() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
}
