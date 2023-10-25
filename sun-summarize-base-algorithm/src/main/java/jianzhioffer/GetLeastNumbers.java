package jianzhioffer;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * 获取最小的k个数
 * <p>
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 示例
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 限制
 * 0 <= k <= arr.length <= 10000
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年10月25日 15:47:00
 */
@SuppressWarnings("unchecked")
public class GetLeastNumbers {

	/**
	 * 复杂度分析
	 * 时间复杂度：O(nlogk)，其中 n 是数组 arr 的长度。由于大根堆实时维护前 k 小值，所以插入删除都是 O(logk) 的时间复杂度，
	 * 最坏情况下数组里 n 个数都会插入，所以一共需要 O(nlogk) 的时间复杂度。
	 * 空间复杂度：O(k)，因为大根堆里最多 k 个数。
	 *
	 * @param arr 数组
	 * @param k   前k个数
	 * @return int[]
	 */
	public int[] getLeastNumbers(int[] arr, int k) {
		// 特例情况
		if (k == 0) {
			return new int[k];
		}

		PriorityQueue<Integer> queue = new PriorityQueue((Comparator<Integer>) (o1, o2) -> o2 - o1);

		for (int i = 0; i < arr.length; i++) {

			if (i < k) {
				queue.offer(arr[i]);
			} else if (Objects.nonNull(queue.peek()) && queue.peek() > arr[i]) {
				queue.poll();
				queue.offer(arr[i]);
			}
		}

		return queue.stream().mapToInt(Integer::intValue).toArray();
	}
}
