package jianzhioffer;

import java.util.PriorityQueue;

/**
 * 得到一个数据流中的中位数
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年10月25日 16:24:00
 */
public class GetMidNums {
	/**
	 * 小顶堆，存储右半边元素，并且右半边元素都大于左半边
	 */
	private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

	/**
	 * 大顶堆，存储左半边元素
	 */
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

	/**
	 * 当前数据流读入的元素个数
	 */
	private int count = 0;

	public void Insert(Integer num) {
		// 位运算判断偶数
		if ((count & 1) == 0) {
			maxHeap.add(num);
			minHeap.add(maxHeap.poll());
		} else {
			minHeap.add(num);
			maxHeap.add(minHeap.poll());
		}
		count++;
	}

	public Double GetMedian() {
		// 位运算判断奇数
		if ((count & 1) != 0) {
			return (double) minHeap.peek();
		} else {
			return (minHeap.peek() + maxHeap.peek()) / 2.0;
		}
	}
}
