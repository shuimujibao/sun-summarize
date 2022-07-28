package juc.cyclicbarrier;

import juc.threadpool.ThreadPoolUtil;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 司令下达命令，要求 10 个士兵一起去完成项任务。
 * 这时就会要求 10 个士兵先集合报到，接着，一起雄赳赳，气昂昂地去执行任务当 10 个士兵把自己手上的任务都执行完了，那么司令才能对外宣布，任务完成
 *
 * @summary Test
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月27日 19:32:00
 */
public class Test {
	public static void main(String[] args) {
		// 线程池定义
		ThreadPoolExecutor threadPool = ThreadPoolUtil.getThreadPool();

		// 到达栅栏执行的动作
		ActionWorker barrierAction = new ActionWorker();

		// 栅栏的定义，parties不得超过核心线程数
		CyclicBarrier cyclicBarrier = new CyclicBarrier(10, barrierAction);

		// 前来报道100个士兵
		for (int i = 0; i < 100; i++) {
			TaskWorker taskWorker = new TaskWorker(cyclicBarrier, i);
			threadPool.submit(taskWorker);
		}

		// 关闭线程池
		threadPool.shutdown();
	}
}
