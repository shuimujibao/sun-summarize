package juc.cyclicbarrier;

/**
 * ActionWorker
 *
 * @summary ActionWorker
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月27日 19:16:00
 */
public class ActionWorker implements Runnable {

	@Override
	public void run() {
		System.out.println("当前组10名士兵执行任务去啦！！！");
	}
}
