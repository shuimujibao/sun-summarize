package didi.second;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunxiaoyu3
 * @description 三个线程交替打印一到100 主线程打印完毕
 * @createTime 2020/11/06 17:29:00
 * <p>
 * 思路
 * +-------------------------------+
 * 1  --->    1%3=1   线程一
 * 2  --->    2%3=2         线程二
 * 3  --->    3%3=0               线程三
 * 4  --->    4%3=1   线程一
 * 5  --->    5%3=2         线程二
 * 6  --->    6%3=0               线程三
 * 7  --->    7%3=1   线程一
 * +-------------------------------+
 * <p>
 * <p>
 * 不打印不应该当前线程打印的数字
 * 如果此时不该打印是
 */
public class Worker implements Runnable {

	/**
	 * 当前线程id
	 */
	private int threadId;

	/**
	 * 控制主线程输出
	 */
	private CountDownLatch countDownLatch;

	private static ReentrantLock lock = new ReentrantLock();

	private static Condition condition = lock.newCondition();

	/**
	 * 打印数字最大值
	 */
	private int n;

	Worker(int threadId, CountDownLatch countDownLatch, int n) {
		this.threadId = threadId;
		this.countDownLatch = countDownLatch;
		this.n = n;
	}

	@Override
	public void run() {
		for (int i = 1; i <= n; ) {
			try {
				lock.lock();
				if (i % 3 == threadId) {
					count(i);
					condition.await();
				}
				condition.signalAll();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
				i++;
			}
		}
	}

	private void count(int i) {
		try {
			System.out.println("第" + i + "次输出===" + "当前线程ID为===" + threadId + "===输出数字===" + i);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			countDownLatch.countDown();
		}
	}
}

