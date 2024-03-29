package record;

import java.util.Objects;

/**
 * @description: 分割数字
 * @author: xy.sun06
 * @create: 2024-03-28 15:51
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class SplitNums2 {
	public static void main(String[] args) {
		String s = "1000222331";
		int n = 2;
		String maxNum = SplitNums2.getMaxNum(s, n);
		System.out.println("最大值：" + maxNum);
	}

	/**
	 * 1.给定数字字符串s,和截取个数n,n不超过字符串的长度
	 * 2.按照n的个数，随意切割s,获取s剩下的数字字符串和，最大值
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

		// 双指针处理
		// 慢指针为 i,快指针为 i+n
		for (int i = 0; i + n < s.length(); i++) {
			// 指针定义
			int fast = i + n;
			// 获取分割后字符串,numsTwo需要跳过前缀 0;
			String numsOne = s.substring(0, i);
			while (Integer.parseInt(String.valueOf(s.charAt(fast))) == 0) {
				fast++;
			}
			String numsTwo = s.substring(fast);
			// 比较大小
			maxNum = stringNumFirstIsGreat(numsOne, maxNum) ? numsOne : maxNum;
			maxNum = stringNumFirstIsGreat(numsTwo, maxNum) ? numsTwo : maxNum;
		}

		// 返回值
		return maxNum;
	}

	/**
	 * 判断两个数字字符串大小
	 *
	 * @param numsOne 字符串一
	 * @param numsTwo 字符串二
	 * @return Boolean
	 */
	private static Boolean stringNumFirstIsGreat(String numsOne, String numsTwo) {
		// 数字字符串相同
		if (Objects.equals(numsOne, numsTwo)) {
			return false;
		}

		// 位数不同
		if (numsOne.length() > numsTwo.length()) {
			return true;
		}

		if (numsOne.length() < numsTwo.length()) {
			return false;
		}

		// 位数相同，比较值
		int index = 0;
		while (index < numsOne.length()) {
			if (Integer.parseInt(String.valueOf(numsOne.charAt(index)))
				> Integer.parseInt(String.valueOf(numsTwo.charAt(index)))) {
				return true;
			}
			if (Integer.parseInt(String.valueOf(numsOne.charAt(index)))
				< Integer.parseInt(String.valueOf(numsTwo.charAt(index)))) {
				return false;
			}
			if (Objects.equals(Integer.parseInt(String.valueOf(numsOne.charAt(index))),
				Integer.parseInt(String.valueOf(numsTwo.charAt(index))))) {
				index++;
			}
		}

		// 数字字符串相同
		return false;
	}
}
