package multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Test
 *
 * @summary Test
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月28日 17:06:00
 */
public class Test {
	public static void main(String[] args) {

		// 创建内存线程池
		ExecutorService executorService = Executors.newCachedThreadPool();

		// 打印次数
		int n = 200;

		// 待输出字符
		String name = null;

		// 创建三个线程
		for (int i = 0; i < 3; i++) {
			if (i % 3 == 0) {
				name = "A";
			}
			if (i % 3 == 1) {
				name = "B";
			}
			if (i % 3 == 2) {
				name = "C";
			}
			executorService.submit(new PrintABCUsingLock(i, n, name));
		}

		// 关闭线程池
		executorService.shutdown();
	}
}
