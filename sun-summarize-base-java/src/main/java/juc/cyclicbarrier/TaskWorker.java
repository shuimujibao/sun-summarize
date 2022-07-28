package juc.cyclicbarrier;

import lombok.SneakyThrows;

import java.util.concurrent.CyclicBarrier;

/**
 * TaskWorker
 *
 * @summary TaskWorker
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月27日 19:32:00
 */
public class TaskWorker implements Runnable {

	private CyclicBarrier cyclicBarrier;
	private int num;

	TaskWorker(CyclicBarrier cyclicBarrier, int num) {
		this.cyclicBarrier = cyclicBarrier;
		this.num = num;
	}


	@SneakyThrows
	@Override
	public void run() {
		System.out.println("士兵 " + num + "到啦！");
		cyclicBarrier.await();
//		cyclicBarrier.reset();
	}
}
