package multithread.printabc.method2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 思路
 * * +-------------------------------+
 * * 1  ---> A   1%3=1   线程一
 * * 2  ---> B   2%3=2         线程二
 * * 3  ---> C   3%3=0               线程三
 * * 4  ---> A   4%3=1   线程一
 * * 5  ---> B   5%3=2         线程二
 * * 6  ---> C   6%3=0               线程三
 * * 7  ---> A   7%3=1   线程一
 * * +-------------------------------+
 * * <p>
 * * 一号线程只打印A
 * * 二号线程只打印B
 * * 三号线程只打印C
 *
 * @summary 三个线程分别打印 A，B，C，要求这三个线程一起运行，打印 n 次，输出形如“ABCABCABC....”的字符串
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月28日 18:15:00
 */
public class Test {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newCachedThreadPool();

		executorService.submit(new A());
		executorService.submit(new B());
		executorService.submit(new C());

		executorService.shutdown();
	}

	/**
	 * 同一时刻只能打印一个字符串
	 */
	private static ReentrantLock lock = new ReentrantLock();

	/**
	 * 打印次数
	 */
	private static final int n = 100;

	/**
	 * 线程A
	 */
	static class A implements Runnable {
		// 编号
		private static final int NumberA = 0;

		@Override
		public void run() {
			try {
				lock.lock();
				System.out.println("A");
			} finally {
				lock.unlock();
			}
		}
	}

	/**
	 * 线程B
	 */
	static class B implements Runnable {

		// 编号
		private static final int NumberB = 1;

		@Override
		public void run() {
			try {
				lock.lock();
				System.out.println("B");
			} finally {
				lock.unlock();
			}
		}
	}

	/**
	 * 线程C
	 */
	static class C implements Runnable {

		// 编号
		private static final int NumberC = 2;

		@Override
		public void run() {
			try {
				lock.lock();
				System.out.println("C");
			} finally {
				lock.unlock();
			}
		}
	}
}
