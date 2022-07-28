package juc.semaphore;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

/**
 * Worker
 *
 * @summary Worker
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月28日 10:53:00
 */
public class Worker implements Runnable {

	private Semaphore semaphore;

	Worker(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@SneakyThrows
	@Override
	public void run() {
		semaphore.acquire();
		System.out.println("执行啦！");
		Thread.sleep(3000);
		semaphore.release();
	}
}
