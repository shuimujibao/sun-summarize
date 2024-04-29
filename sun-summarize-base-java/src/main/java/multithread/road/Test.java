package multithread.road;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 统计10个运动员跑步耗时
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年09月27日 17:51:00
 */
@SuppressWarnings("unchecked")
public class Test {


	public static void main(String[] args) throws InterruptedException, ExecutionException {

		// 线程池
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		// 运动员跑道就位
		CountDownLatch countDownLatchPre = new CountDownLatch(10);

		// 运动员跑步结束统计
		CountDownLatch countDownLatchOver = new CountDownLatch(10);

		List<Future> futures = new ArrayList<>();

		for (int i = 0; i < 10; i++) {

			countDownLatchPre.countDown();

			Future submit = executorService.submit(new Sport(countDownLatchPre, countDownLatchOver));

			futures.add(submit);

		}

		countDownLatchOver.await();

		// 统计10个运动员耗时
		Integer sum = 0;
		for (Future future : futures) {
			Integer o = (Integer) future.get();
			sum = sum + o;
		}

		executorService.shutdown();
		System.out.print("总耗时：" + sum);
	}


	public static class Sport implements Callable {

		// 运动员跑道就位
		private CountDownLatch countDownLatchPre;

		// 运动员跑步结束统计
		private CountDownLatch countDownLatchOver;


		Sport(CountDownLatch countDownLatchPre, CountDownLatch countDownLatchOver) {
			this.countDownLatchPre = countDownLatchPre;
			this.countDownLatchOver = countDownLatchOver;
		}

		@Override
		public Object call() throws Exception {

			// 等待其他运动员就位
			countDownLatchPre.await();

			// 当运动员比赛耗时
			int randomNum = ThreadLocalRandom.current().nextInt(100);
			System.out.println("运动员：" + Thread.currentThread() + "耗时：" + randomNum);

			// 当前运动员比赛结束
			countDownLatchOver.countDown();

			return randomNum;
		}
	}
}
