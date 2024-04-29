package record;

import java.util.Objects;

/**
 * @description: 分割数字
 * @author: xy.sun06
 * @create: 2024-03-28 15:51
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class SplitNums {
	public static void main(String[] args) {
		String s = "34567898765456";
		int n = 2;
		String maxNum = SplitNums.getMaxNum(s, n);
		System.out.println("最大值：" + maxNum);
	}

	/**
	 * 1.给定数字字符串s,和截取个数n,n不超过字符串的长度
	 * 2.按照n的个数，随意切割s,获取s剩下的数字字符串，最大值
	 *
	 * @param s 数字字符串
	 * @param n 截取个数
	 */
	public static String getMaxNum(String s, int n) {
		// 截取个数为 0，返回当前数字字符串
		if (n == 0) {
			return s;
		}

		// 最大数字字符串
		String maxNum = "0";

		// 分割字符串,只分割一次位数最多
		for (int i = 0; i + n < s.length(); i++) {
			// 分割
			String num1 = s.substring(0, i);
			String num2 = s.substring(i + n - 1);

			// 拼接
			String num = num1 + num2;

			// 比较
			maxNum = stringNumFirstIsGreat(maxNum, num) ? maxNum : num;
		}

		// 返回值
		return maxNum;
	}

	/**
	 * @param s1 字符串
	 * @param s2 字符串
	 * @return boolean
	 */
	private static Boolean stringNumFirstIsGreat(String s1, String s2) {
		int s1Point = 0;
		int s2Point = 0;
		// 跳过前缀0;
		while (s1Point < s1.length() && s2Point < s2.length()) {
			if (s1.charAt(s1Point) == 0) {
				s1Point++;
			}
			if (s2.charAt(s2Point) == 0) {
				s2Point++;
			}
		}
		// 重新赋值
		s1 = s1.substring(s1Point);
		s2 = s2.substring(s2Point);
		s1Point = 0;
		s2Point = 0;
		// 比教位数
		if (s1.length() > s2.length()) {
			return true;
		}

		if (s1.length() < s2.length()) {
			return false;
		}
		// 位数相同，从高位向低位遍历比较
		while (s1Point < s1.length() && s2Point < s2.length()) {
			if (Objects.equals((int) s1.charAt(s1Point), (int) s2.charAt(s2Point))) {
				s1Point++;
				s2Point++;
			}
			if ((int) s1.charAt(s1Point) > (int) s2.charAt(s2Point)) {
				return true;
			}
			if ((int) s1.charAt(s1Point) < (int) s2.charAt(s2Point)) {
				return false;
			}
		}
		// 此时两数字字符串相同
		return false;
	}
}
