package jianzhioffer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。在该栈中，调用min、push及pop的时间复杂度都是O(1)。
 * <p>
 * 1、要将 min() 函数复杂度降为 O(1)，可以用空间换时间，用一个单独的栈来辅助实现查询最小值。
 * 即除在A栈正常进行入栈出栈操作时，对每次进栈的元素与B栈的栈顶元素比较，使B栈的栈顶元素始终为最小值。
 * 2、要使元素出栈后，当该元素恰为最小元素时，B栈取的栈顶元素仍为A栈中剩余元素中的最小元素，故在执行pop()时，应与B栈的栈顶元素比较。
 * ————————————————
 * 原文链接：https://blog.csdn.net/weixin_52001449/article/details/123142856
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年10月12日 11:24:00
 */
public class GetMInStack {

	private Stack<Integer> A, B;

	public GetMInStack() {
		A = new Stack<>();
		B = new Stack<>();
	}

	public static void main(String[] args) {

	}

	public void push(int x) {
		A.add(x);
		if (B.empty() || B.peek() >= x) {
			B.add(x);
		}
	}

	public void pop() {
		if (A.pop().equals(B.peek())) {
			B.pop();
		}
	}

	public int top() {
		return A.peek();
	}

	public int min() {
		return B.peek();
	}
}
