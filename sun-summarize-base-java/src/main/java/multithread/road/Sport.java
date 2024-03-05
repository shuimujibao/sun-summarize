package multithread.road;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 一个运动员
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年09月27日 17:50:00
 */
public class Sport implements Callable {

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

		// 当前运动员比赛结束
		countDownLatchOver.countDown();

		return randomNum;
	}
}
