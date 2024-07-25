package baidu.first;

import java.util.Stack;

/**
 * WriteExamOne
 *
 * @summary 实现一个栈，并提供方法获取栈中最小的值
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 贝壳找房（北京）科技有限公司
 * @since: 2022年04月24日 12:02:00
 */
public class WriteExamOne {
	private static Stack<Integer> stack = new Stack<>();

	private static Stack<Integer> minStack = new Stack<>();

	public void add(Integer elem) {
		stack.add(elem);

		if (minStack.peek() >= elem) {
			minStack.add(elem);
		}
	}

	public Integer pop() {
		return stack.pop();
	}

	public Integer getMinNum() {
		return minStack.peek();
	}
}
