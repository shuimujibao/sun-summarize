package monotonous;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description: 单调队列-获取队列最大值
 * @author: xy.sun06
 * @create: 2024-08-21 20:26
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class MonotonousQueue {

	// 记录队列中所有元素
	Deque<Integer> queue = new ArrayDeque<>();

	// 阶段性记录队列中的最大元素
	Deque<Integer> minQueue = new ArrayDeque<>();

	/**
	 * eg: 队列最大值
	 * <p>
	 * 入队 1   单调队列新增 1
	 * 入队 5   获取单调队列队尾的值，若队尾的值小于输入值，则移除当前队尾值，然后新增当前值，此时单调队列中的值为5
	 * 入队 3   单调队列新增 3，单调队列中值为 5—>3
	 * 入队 2   单调队列新增 2，单调队列中值为 5—>3->2
	 * 入队 4   获取单调队列队尾的值2,若队尾的值2小于输入值4,则移除当前队尾值2,然后新增当前值4,此时单调队列中的值为5—>3->4
	 * <p>
	 * 开始出队（先进先出）
	 * <p>
	 * 1 出队  获取单调队列队首的值，判断是否为当前出队的值，不是则单调队列不动 仍旧为5—>3->4
	 * 5 出队  获取单调队列队首的值5，经判断出队的5和单调队列中的5相等，单调队列出队 3->4
	 * 此时队列中的值为 3->2->4
	 * 此时单调队列中的值为 3->4
	 * <p>
	 * ==========总结==========
	 * 入队：获取单调队列队尾的值，若队尾的值大于输入值直接新增到队尾，若队尾的值小于输入值，则移除当前队尾值，然后再新增当前值
	 * 出队：获取单调队列队首的值，判断是否为当前出队的值，不是则单调队列不动，是则跟随出队
	 * <p>
	 * ==========思考如何获取队列最小值==========
	 *
	 * @param n 输入值
	 */
	public void push(int n) {
		queue.add(n);
		// 将小于 n 的元素全部删除
		while (!minQueue.isEmpty() && minQueue.getLast() < n) {
			minQueue.pollLast();
		}
		// 然后将 n 加入尾部
		minQueue.addLast(n);
	}

	public int max() {
		return minQueue.getFirst();
	}

	public void pop(int n) {
		queue.pop();
		if (n == minQueue.getFirst()) {
			minQueue.pollFirst();
		}
	}
}
