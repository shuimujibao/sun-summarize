package zijie.first;

import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * WriteExam
 *
 * @summary n个有序数组，每个数组m个值，求第K大的数
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 贝壳找房（北京）科技有限公司
 * @since: 2022年05月07日 18:06:00
 */
public class WriteExamOne {

	/**
	 * n个有序数组，每个数组m个值，求第K大的数
	 *
	 * @param n n个有序数组
	 * @param k 第k大
	 * @return Integer
	 */
	public Integer kMaxValue(List<int[]> n, Integer k) {
		Integer res = Integer.MIN_VALUE;

		// 大顶堆
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

		for (int[] ints : n) {

			Integer peek = maxHeap.peek();
			if (Objects.nonNull(peek) && ints[0] < peek) {
				continue;
			}

			for (int value : ints) {
				if (Objects.nonNull(peek) && value > peek) {
					maxHeap.poll();
				}
				maxHeap.add(value);
			}
		}

		return res;
	}
}
