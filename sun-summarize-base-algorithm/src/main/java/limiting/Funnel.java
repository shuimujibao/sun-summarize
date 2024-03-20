package limiting;

/**
 * 1.Funnel类表示一个漏斗对象，其中包含了漏斗容量、漏水速度、剩余配额和上次漏水时间等属性，
 * 2.通过makeSpace()方法实现漏水操作，tryAcquire()方法用于请求配额。
 * 3.通过main方法进行漏斗算法的简单测试，模拟多次请求，并输出请求成功或失败的信息。
 *
 * @description: 漏斗算法-gpt
 * @author: xy.sun06
 * @create: 2024-03-19 15:00
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class Funnel {
	/**
	 * 漏斗容量
	 */
	private final int capacity;

	/**
	 * 漏水速度
	 */
	private final float leakingRate;

	/**
	 * 剩余配额
	 */
	private int leftQuota;

	/**
	 * 上次漏水时间
	 */
	private long lastLeakTime;

	/**
	 * 漏斗初始化
	 *
	 * @param capacity    漏斗容量
	 * @param leakingRate 漏水速度
	 */
	public Funnel(int capacity, float leakingRate) {
		this.capacity = capacity;
		this.leakingRate = leakingRate;
		this.leftQuota = capacity;
		this.lastLeakTime = System.currentTimeMillis();
	}

	/**
	 * 漏水方法
	 */
	private void makeSpace() {
		long currentTime = System.currentTimeMillis();
		long timeDelta = currentTime - lastLeakTime;
		int leakedQuota = (int) (timeDelta * leakingRate);
		if (leakedQuota < 0) {
			// 时间设置错误，重置为当前时间
			lastLeakTime = currentTime;
			return;
		}
		if (leakedQuota < 1) {
			// 漏水速度太慢，不进行漏水
			return;
		}
		leftQuota += leakedQuota;
		lastLeakTime = currentTime;
		if (leftQuota > capacity) {
			// 超过漏斗容量时，重置为容量值
			leftQuota = capacity;
		}
	}

	/**
	 * 请求配额方法
	 *
	 * @param quota
	 * @return
	 */
	public boolean tryAcquire(int quota) {
		// 先漏水
		makeSpace();
		if (leftQuota >= quota) {
			leftQuota -= quota;
			return true;
		}
		return false;
	}

	/**
	 * 模拟执行
	 *
	 * @param args 主方法
	 */
	public static void main(String[] args) {
		// 容量100，漏水速度0.5
		Funnel funnel = new Funnel(100, 0.5f);
		for (int i = 0; i < 200; i++) {
			if (funnel.tryAcquire(1)) {
				System.out.println("第" + i + "次请求成功");
			} else {
				System.out.println("第" + i + "次请求失败");
			}
		}
	}
}
