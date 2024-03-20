package limiting;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 1.在TokenBucket类中，构造方法初始化了令牌桶的容量和发放速率。
 * 2.tryConsume方法尝试从令牌桶中获取一个令牌，如果令牌桶中有足够的令牌，则会减少一个令牌并返回true，否则返回false。
 * 3.refill方法用于补充令牌桶中的令牌，根据时间间隔和发放速率计算新的令牌数量，并更新令牌桶中的令牌数量。
 * 4.在main方法中，模拟了15次尝试获取令牌的过程并打印结果。
 *
 * @description: 令牌桶算法-gpt
 * @author: xy.sun06
 * @create: 2024-03-19 15:13
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class TokenBucket {
	private final long capacity;
	private final long rate;
	private AtomicLong tokens;
	private Long lastRefillTime;

	public TokenBucket(long capacity, long rate) {
		this.capacity = capacity;
		this.rate = rate;
		this.tokens = new AtomicLong(capacity);
		this.lastRefillTime = System.currentTimeMillis();
	}

	public synchronized boolean tryConsume() {
		refill();
		if (tokens.get() > 0) {
			tokens.decrementAndGet();
			return true;
		} else {
			return false;
		}
	}

	private synchronized void refill() {
		long now = System.currentTimeMillis();
		long elapsed = now - lastRefillTime;
		if (elapsed > 0) {
			long newTokens = elapsed * rate / 1000;
			tokens.set(Math.min(capacity, tokens.get() + newTokens));
			lastRefillTime = now;
		}
	}

	public static void main(String[] args) {
		TokenBucket tokenBucket = new TokenBucket(10, 1);

		for (int i = 0; i < 15; i++) {
			if (tokenBucket.tryConsume()) {
				System.out.println("Token consumed");
			} else {
				System.out.println("Token not available");
			}
		}
	}
}

