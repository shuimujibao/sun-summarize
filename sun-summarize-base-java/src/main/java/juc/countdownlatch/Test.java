package juc.countdownlatch;

import juc.threadpool.ThreadPoolUtil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Test
 *
 * @summary Test
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月27日 19:17:00
 */
public class Test {

	public static void main(String[] args) throws InterruptedException {

		CountDownLatch countDownLatch = new CountDownLatch(2);

		ThreadPoolExecutor threadPool = ThreadPoolUtil.getThreadPool();

		ThreadOne threadOne = new ThreadOne(countDownLatch);
		ThreadTwo threadTwo = new ThreadTwo(countDownLatch);
		threadPool.submit(threadTwo);
		threadPool.submit(threadOne);

		countDownLatch.await();

		System.out.println("任务执行完毕！");

		threadPool.shutdown();
	}
}
