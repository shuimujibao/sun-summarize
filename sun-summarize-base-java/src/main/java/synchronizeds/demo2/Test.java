package synchronizeds.demo2;

import juc.threadpool.ThreadPoolUtil;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Test
 *
 * @summary Test
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月28日 11:23:00
 */
public class Test {

	public static void main(String[] args) {

		ThreadPoolExecutor threadPool = ThreadPoolUtil.getThreadPool();

		threadPool.submit(new ThreadOne());
		threadPool.submit(new ThreadTwo());
		threadPool.submit(new ThreadThree());
		System.out.println("任务投递完成！");
		threadPool.shutdown();
	}

	/**
	 * 锁住static修饰的方法，等同于锁类文件 即当前类所创建的对象
	 */
	synchronized static void test() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("执行锁定静态方法！！！");
	}

	/**
	 * 锁定类
	 */
	void test2() throws InterruptedException {
		synchronized (Test.class) {
			Thread.sleep(5000);
			System.out.println("执行锁定类方法！！！");
		}
	}

	/**
	 * 普通方法
	 */
	void test3() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("执行普通方法！！！");
	}
}
