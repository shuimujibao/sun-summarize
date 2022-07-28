package synchronizeds.demo1;

import lombok.SneakyThrows;

/**
 * ThreadOne
 *
 * @summary ThreadOne
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月28日 11:24:00
 */
public class ThreadOne implements Runnable {

	@SneakyThrows
	@Override
	public void run() {
		Test test = new Test();
		test.test();
	}
}
