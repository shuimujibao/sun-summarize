package meituan.second;

import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @description: 算法-最小 K个数
 * @author: xy.sun06
 * @create: 2024-07-15 10:46
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class WriteExam {
	public static void main(String[] args) {
		int[] arr = new int[]{1, 1, 42, 121, 42, 15};
	}

	/**
	 * 获取数据中最小的k个数
	 *
	 * @param arr 数据
	 * @param k   K个数
	 * @return List<Integer>
	 */
	public int[] KMinNum(int[] arr, int k) {

		// 参数检查
		if (Objects.isNull(arr) || arr.length < k) {
			return arr;
		}
		// 小顶堆
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		// 构造k个节点的小顶堆
		for (int j : arr) {
			minHeap.offer(j);
		}

		int[] result = new int[k];
		for (int i = 0; i < k; i++) {

			Integer poll = minHeap.poll();

			if (Objects.isNull(poll)) {
				continue;
			}

			result[i] = poll;
		}

		return result;
	}
}
