package multithread.printabc.method1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * PrintABCUsingLock
 *
 * @summary 三个线程分别打印 A，B，C，要求这三个线程一起运行，打印 n 次，输出形如“ABCABCABC....”的字符串
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月28日 16:55:00
 */
public class PrintABCUsingLock implements Runnable {

	// 当前线程No
	private int threadNumber;

	// 打印次数
	private int n;

	// 打印字符
	private String name;

	// 保证同一时刻只有一个线程获取输出资源
	private static ReentrantLock lock = new ReentrantLock();

	private static Condition condition = lock.newCondition();

	PrintABCUsingLock(int threadNumber, int n, String name) {
		this.threadNumber = threadNumber;
		this.n = n;
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < n; i++) {
			try {
				lock.lock();
				if (i % 3 == threadNumber) {
					System.out.println("线程名" + Thread.currentThread().getName() + "线程no:" + threadNumber + "输出字符：" + name);
					condition.await();
				}
				condition.signalAll();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}
}
