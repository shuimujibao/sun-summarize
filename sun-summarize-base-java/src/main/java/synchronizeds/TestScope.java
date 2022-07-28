package synchronizeds;

/**
 * 作用域
 *
 * @summary TestScope
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月28日 11:12:00
 */
public class TestScope {
	/**
	 * 测试对象
	 */
	private final Student student = new Student();

	/**
	 * 锁普通方法
	 */
	public synchronized void testOne() {

	}

	/**
	 * 锁静态方法
	 */
	public synchronized static void testOneAnother() {

	}

	/**
	 * 锁对象
	 */
	public void testTwo() {

		synchronized (this) {
			System.out.println("");
		}

		synchronized (student) {
			System.out.println("");
		}
	}

	/**
	 * 锁类
	 */
	public void testThree() {
		synchronized (TestScope.class) {
			System.out.println("");
		}

		synchronized (Student.class) {
			System.out.println("");
		}
	}
}
