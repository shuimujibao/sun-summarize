package hashmap;

/**
 * Test2
 *
 * @summary Test2
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月23日 14:01:00
 */
public class Test2 {

	private static int result = 0;


	public static void main(String[] args) throws InterruptedException {
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();

		thread1.start();
		thread2.start();

//		Thread.sleep(5000);

		System.out.println("result: " + result);
	}

	static class Thread1 extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 1000; i++) {
				add();
			}
		}
	}

	static class Thread2 extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 1000; i++) {
				add();
			}
		}
	}

	private static void add() {
		result++;
	}
}
