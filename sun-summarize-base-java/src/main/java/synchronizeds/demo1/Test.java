package synchronizeds.demo1;

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
		System.out.println("任务投递完成！");
		threadPool.shutdown();
	}

	/**
	 * 待执行方法一
	 */
	void test() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("执行方法一！！！");
	}

	/**
	 * 当前方法锁定对象
	 */
	void test2() throws InterruptedException {
		synchronized (this) {
			Thread.sleep(5000);
			System.out.println("执行锁定方法！！！");
		}
	}
}
