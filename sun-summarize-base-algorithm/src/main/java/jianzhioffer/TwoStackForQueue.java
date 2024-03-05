package jianzhioffer;

import java.util.Stack;

/**
 * 两个栈实现一个队列
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年10月11日 10:15:00
 */
public class TwoStackForQueue {

	private static Stack<Integer> stackOne = new Stack<>();

	private static Stack<Integer> stackTwo = new Stack<>();

	public static void main(String[] args) {

		TwoStackForQueue.put(1);
	}

	/**
	 * 入队列
	 *
	 * @param value 值
	 */
	private static void put(Integer value) {
		stackOne.push(value);

	}

	/**
	 * 出队列
	 *
	 * @return Integer
	 */
	public static Integer get() {

		if (!stackTwo.empty()) {
			return stackTwo.peek();
		}

		if (stackOne.empty()) {
			return -1;

		}

		// 循环将第一个栈 中元素 依次入栈  进入第二个栈
		while (!stackOne.isEmpty()) {
			stackTwo.push(stackOne.pop());
		}

		//返回第二个栈中的 栈顶元素
		return stackTwo.peek();
	}
}
