package juc.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * ThreadTwo
 *
 * @summary ThreadTwo
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月27日 19:16:00
 */
public class ThreadTwo implements Runnable {

	private CountDownLatch countDownLatch;

	ThreadTwo(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		System.out.println("ThreadTwo 任务执行完成！！！");
		countDownLatch.countDown();
	}
}
