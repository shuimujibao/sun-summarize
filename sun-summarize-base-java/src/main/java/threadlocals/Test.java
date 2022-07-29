package threadlocals;

/**
 * 栈上存储
 *
 * @summary Test
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月28日 16:23:00
 */
public class Test {

	/**
	 * 声明栈上存储
	 */
	private ThreadLocal<String> threadLocal = new ThreadLocal<>();

	/**
	 * 入口方法
	 *
	 * @throws InterruptedException 可中断异常
	 */
	private void start() throws InterruptedException {

		System.out.println("进入start方法！");

		threadLocal.set("我是栈上存储的值");

		Thread.sleep(2000);

		end();
	}

	/**
	 * 出口方法
	 */
	private void end() {
		String result = threadLocal.get();
		System.out.println("eng()中获取到了栈上数据 ===>>" + result);
	}

	/**
	 * 启动类
	 */
	public static void main(String[] args) throws InterruptedException {
		new Test().start();
	}
}
