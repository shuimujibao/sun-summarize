package juc.semaphore;

import juc.threadpool.ThreadPoolUtil;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Test
 *
 * @summary Test
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月28日 10:38:00
 */
public class Test {
	public static void main(String[] args) {

		ThreadPoolExecutor threadPool = ThreadPoolUtil.getThreadPool();

		Semaphore semaphore = new Semaphore(3);

		for (int i = 0; i < 100; i++) {
			Worker worker = new Worker(semaphore);
			threadPool.submit(worker);
		}

		threadPool.shutdown();
	}
}
