package didi.second;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * WriteExam
 *
 * @summary 三个线程交替打印一到100 主线程打印完毕
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 贝壳找房（北京）科技有限公司
 * @since: 2022年05月07日 15:25:00
 */
public class WriteExam {
	public static void main(String[] args) throws InterruptedException {

		ExecutorService pool = Executors.newCachedThreadPool();

		CountDownLatch countDownLatch = new CountDownLatch(10);

		int n = 10;

		for (int i = 0; i < 3; i++) {
			pool.submit(new Worker(i, countDownLatch, n));
		}

		countDownLatch.await();
		System.out.println("数字打印完毕！");
		pool.shutdown();

	}
}
