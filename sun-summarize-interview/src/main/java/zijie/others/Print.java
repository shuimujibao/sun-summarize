package zijie.others;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 就是第一个2秒后打印，第二个4秒打印，第三个5s后打印，并且并行调用
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 * @since: 2024年01月12日 15:47:00
 */
public class Print implements Runnable {

	/**
	 * 线程号
	 */
	private Integer threadNums;

	private CountDownLatch countDownLatch;

	Print(Integer threadNums, CountDownLatch countDownLatch) {
		this.threadNums = threadNums;
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		try {
			countDownLatch.countDown();
			countDownLatch.await();
			if (threadNums % 3 == 0) {
				Thread.sleep(5000);
			}
			if (threadNums % 3 == 1) {
				Thread.sleep(4000);
			}
			if (threadNums % 3 == 2) {
				Thread.sleep(2000);
			}
			System.out.println("当前是第" + threadNums + "个线程");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		// 闭锁
		CountDownLatch countDownLatch = new CountDownLatch(3);

		// 设置线程数
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 3; i++) {
			executorService.submit(new Print(i,countDownLatch));
		}
	}
}
