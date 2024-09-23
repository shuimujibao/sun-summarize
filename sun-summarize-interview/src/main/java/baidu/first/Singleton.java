package baidu.first;

/**
 * @description: 单例
 * @author: xy.sun06
 * @create: 2024-07-25 14:17
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class Singleton {

	private static Singleton instance = null;

	// 私有构造函数，防止外部直接创建实例
	private Singleton() {
	}

	/**
	 * ===============================================================================================
	 * ==============================静态代码块=========================================================
	 * ===============================================================================================
	 * ===============================================================================================
	 */

	// 公有方法，提供一个静态的获取实例的方法
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	/**
	 * ===============================================================================================
	 * ===============================================================================================
	 * =====================================静态的同步的获取实例的方法=====================================
	 * ===============================================================================================
	 */
	// 公有方法，提供一个静态的同步的获取实例的方法
	public static synchronized Singleton getInstance2() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	/**
	 * ===============================================================================================
	 * ===============================================================================================
	 * =====================================DCL=====================================
	 * ===============================================================================================
	 */
	private static volatile Singleton singleton;

	public static Singleton getInstance3() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}

	/**
	 * ===============================================================================================
	 * ===============================================================================================
	 * =====================================静态内部类==================================================
	 * ===============================================================================================
	 */
	private static class SingletonInstance {
		private static final Singleton INSTANCE = new Singleton();
	}

	public static Singleton getInstance4() {
		return SingletonInstance.INSTANCE;
	}
}
