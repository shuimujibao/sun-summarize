package limiting;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 1.构造一个令牌桶队列
 * 2.创建一个定时任务，按照指定速率向令牌队列中，补充令牌，
 *   补充令牌过程中判断是否超过令牌数量最大值，若达到最大值，则不向队列中补充令牌
 * 3.用户线程执行前，循环向令牌队列中申请令牌（设置最大循环次数，抵达最大循环数，执行降级策略），
 *   直至获取到令牌，继续执行任务，以此达到限流目的
 *
 * @description: 令牌桶算法
 * @author: xy.sun06
 * @create: 2024-03-19 13:47
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class TokenBucketLimiter {
	/**
	 * 令牌队列
	 */
	private final BlockingQueue<Object> tokenQueue;

	/**
	 * 队列最大令牌数
	 */
	private final int maxTokens;

	/**
	 * 令牌补充速率
	 */
	private final int fillRate;


	/**
	 * 令牌桶限流器初始化
	 *
	 * @param maxTokens 最大令牌数
	 * @param fillRate  令牌补充速率
	 */
	public TokenBucketLimiter(int maxTokens, int fillRate) {
		this.maxTokens = maxTokens;
		this.fillRate = fillRate;
		this.tokenQueue = new LinkedBlockingQueue<>(maxTokens);

		// 初始化令牌桶
		for (int i = 0; i < maxTokens; i++) {
			tokenQueue.offer(new Object());
		}

		// 创建一个定时任务定时填充令牌桶
		new FillRateScheduler().scheduleFillRate(this::fillTokens, fillRate, TimeUnit.SECONDS);
	}

	/**
	 * 定时填充令牌桶
	 */
	private void fillTokens() {
		while (tokenQueue.size() < maxTokens) {
			tokenQueue.offer(new Object());
			if (tokenQueue.size() >= maxTokens) {
				break;
			}
		}
	}

	/**
	 * 获取令牌
	 *
	 * @throws InterruptedException 线程中断异常
	 */
	public void tryAcquire() throws InterruptedException {
		tokenQueue.put(new Object());
	}

	/**
	 * 定时任务类
	 * 用于按指定频率填充令牌桶
	 */
	private static class FillRateScheduler {
		public void scheduleFillRate(Runnable runnable, int rate, TimeUnit timeUnit) {
			Thread thread = new Thread(() -> {
				while (true) {
					try {
						timeUnit.sleep(rate);
						runnable.run();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						break;
					}
				}
			});
			thread.setDaemon(true);
			thread.start();
		}
	}

	public static void main(String[] args) {
		// 令牌桶容量10，填充速率1次/秒
		TokenBucketLimiter limiter = new TokenBucketLimiter(10, 1);
		while (true) {
			try {
				limiter.tryAcquire();
				System.out.println("Token acquired");
				Thread.sleep(800); // 模拟请求处理时间
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				break;
			}
		}
	}
}
