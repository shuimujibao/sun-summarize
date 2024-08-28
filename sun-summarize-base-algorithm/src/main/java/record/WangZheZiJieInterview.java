package record;

import java.util.LinkedList;

/**
 * @description:
 * @author: xy.sun06
 * @create: 2024-08-27 07:36
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class WangZheZiJieInterview {


	public static void main(String[] args) {
		int[] arr = new int[]{0, 1, 1, 0};

		WangZheZiJieInterview wangZheZiJieInterview = new WangZheZiJieInterview();
		Integer longest = wangZheZiJieInterview.longest(arr);
		System.out.println(longest);
	}

	private Integer longest(int[] arr) {
		backTrace(arr, 0);
		return maxLength;
	}

	/**
	 * 寻找arr的子数组，子数组要求0，1 数量一般多，即子数据和 = sum/2
	 */
	private int maxLength = Integer.MIN_VALUE;

	/**
	 * 路径
	 */
	LinkedList<Integer> path = new LinkedList<>();

	private void backTrace(int[] arr, int start) {

		// 计算路径和
		int sum = path.stream()
			.mapToInt(Integer::intValue)
			.sum();

		int size = path.size();

		// 判断子数据0，1是否同样多
		if (size == (sum * 2)) {
			maxLength = Math.max(maxLength, size);
		}

		for (int i = start; i < arr.length; i++) {
			path.add(arr[i]);
			backTrace(arr, i + 1);
			path.removeLast();
		}
	}
}
