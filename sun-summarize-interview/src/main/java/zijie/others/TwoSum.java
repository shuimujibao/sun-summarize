package zijie.others;

import java.util.Stack;

/**
 * 876454872464854加上7584276484845
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 * @since: 2024年01月12日 14:57:00
 */
public class TwoSum {

	public static void main(String[] args) {
		String nums = "32513";
		char c = nums.charAt(0);
		char c1 = nums.charAt(1);
		int m = Integer.parseInt(String.valueOf(c));
		int n = Integer.parseInt(String.valueOf(c1));
		System.out.println(m+n);

	}

	/**
	 * 两大数之和
	 *
	 * @param s1 数字字符串一
	 * @param s2 数字字符串二
	 * @return 两数之和
	 */
	public String sum(String s1, String s2) {
		// 进位值
		int currentValue = 0;

		// 存储
		Stack<Integer> stack = new Stack<>();

		// 倒着遍历
		while (!s1.isEmpty() && !s2.isEmpty()) {
			// 分别获取最后一位
			char num1 = s1.charAt(s1.length() - 1);
			char num2 = s2.charAt(s2.length() - 1);

			// 获取商（包含进位）
			currentValue = (num1 + num2 + currentValue) / 10;

			// 获取余数
			int value = (num1 + num2) % 10;

			stack.add(value);

			s1 = s1.substring(0, s1.length() - 1);
			s2 = s2.substring(0, s2.length() - 1);
		}

		while (!s1.isEmpty()) {
			// 获取最后一位
			char num1 = s1.charAt(s1.length() - 1);
			// 获取商（包含进位）
			currentValue = (num1 + currentValue) / 10;
			// 获取余数
			int value = num1 % 10;
			stack.add(value);
		}

		while (!s2.isEmpty()) {
			// 获取最后一位
			char num2 = s2.charAt(s2.length() - 1);
			// 获取商（包含进位）
			currentValue = (num2 + currentValue) / 10;
			// 获取余数
			int value = num2 % 10;
			stack.add(value);
		}

		StringBuilder result = new StringBuilder();
		while (!stack.isEmpty()) {
			result.append(stack.pop());
		}

		return result.toString();
	}

	/**
	 * 两大数之和
	 *
	 * @param s1 数字字符串一
	 * @param s2 数字字符串二
	 * @return 两数之和
	 */
	public String sumTwo(String s1, String s2) {
		// 进位值
		int currentValue = 0;

		// 存储
		Stack<Integer> stack = new Stack<>();

		// 倒着遍历
		while (!s1.isEmpty() || !s2.isEmpty()) {
			// 分别获取最后一位
			char num1 = s1.length() > 0 ? s1.charAt(s1.length() - 1) : 0;
			char num2 = s2.length() > 0 ? s2.charAt(s2.length() - 1) : 0;

			// 获取商（包含进位）
			currentValue = (currentValue + num1 + num2) / 10;

			// 获取余数
			int value = (num2 + num1) % 10;

			stack.add(value);

			s1 = s1.substring(0, s1.length() - 1);
			s2 = s2.substring(0, s2.length() - 1);
		}

		if (currentValue != 0) {
			stack.add(currentValue);
		}

		StringBuilder result = new StringBuilder();
		while (!stack.isEmpty()) {
			result.append(stack.pop());
		}

		return result.toString();
	}
}
