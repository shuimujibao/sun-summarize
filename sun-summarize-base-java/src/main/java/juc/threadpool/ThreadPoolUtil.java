package juc.threadpool;

import java.util.concurrent.*;

/**
 * ThreadPoolUtil
 *
 * @summary ThreadPoolUtil
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月27日 19:03:00
 */
public class ThreadPoolUtil {
	// 核心线程数
	private static final int corePoolSize = 5;
	// 最大线程数
	private static final int maximumPoolSize = 10;
	// 线程保留时间
	private static final int keepAliveTime = 1;
	// 线程保留时间单位
	private static final TimeUnit unit = TimeUnit.SECONDS;
	// 阻塞队列
	private static final BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>(100);
	// 拒绝策略
	private static final RejectedExecutionHandler defaultHandler = new ThreadPoolExecutor.AbortPolicy();
	// 初始化线程池
	private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,
		maximumPoolSize,
		keepAliveTime,
		unit,
		workQueue,
		defaultHandler);

	// 获取线程池
	public static ThreadPoolExecutor getThreadPool() {
		return threadPoolExecutor;
	}
}
