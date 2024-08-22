package tantan.first;

import java.util.LinkedList;

/**
 * WriteExamOne
 *
 * @summary 设计一个先进先出的队列，并在时间复杂度为O(1)的条件下 支持获取当前队列最大值
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 贝壳找房（北京）科技有限公司
 * @since: 2022年05月07日 17:22:00
 */
public class WriteExamOne {
	LinkedList<Integer> q = new LinkedList<>();

	/**
	 * 入队
	 * 若当前队尾的值小于当前输入值，则移除后当前值入队
	 * 若当前队尾的值不小于当前输入值，当前值直接入队
	 * <p>
	 * 此时保证队列头为最大值
	 *
	 * @param n 入队值
	 */
	public void push(int n) {
		// 将小于 n 的元素全部删除
		while (!q.isEmpty() && q.getLast() < n) {
			q.pollLast();
		}
		// 然后将 n 加入尾部
		q.addLast(n);
	}

	/**
	 * 队列头为最大值
	 *
	 * @return maxValue
	 */
	public int max() {
		return q.getFirst();
	}

	/**
	 * 正常队列中的值出队时
	 * <p>
	 * 若当前值为最大值，即队列头，单调队列也需出队该值
	 * 若当前值非最大值，单调队列的值无需出队
	 *
	 * @param n 待出队的值
	 */
	public void pop(int n) {
		if (n == q.getFirst()) {
			q.pollFirst();
		}
	}

	public static void main(String[] args) {
		// 单调队列
		WriteExamOne writeExamOne = new WriteExamOne();

		writeExamOne.push(6);
		writeExamOne.push(-1);
		writeExamOne.push(5);

		// 为什么不能用一个全局变量记录最大值
		// 即这种情况，移除的值为当前队列的最大值
		int max = writeExamOne.max();
		System.out.println(max);
		writeExamOne.pop(6);
		int max2 = writeExamOne.max();
		System.out.println(max2);

	}
}
