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
	private final PriorityQueue<Integer> large;
	private final PriorityQueue<Integer> small;

	public GetMidNums() {
		// 小顶堆
		large = new PriorityQueue<>();
		// 大顶堆
		small = new PriorityQueue<>((a, b) -> b - a);
	}

	public double findMedian() {

		// 如果元素不一样多，多的那个堆的堆顶元素就是中位数
		if (large.size() < small.size()) {
			return small.peek();
		} else if (large.size() > small.size()) {
			return large.peek();
		}
		// 如果元素一样多，两个堆堆顶元素的平均数是中位数
		return (large.peek() + small.peek()) / 2.0;

	}

	public void addNum(int num) {
		if (small.size() >= large.size()) {
			small.offer(num);
			large.offer(small.poll());
		} else {
			large.offer(num);
			small.offer(large.poll());
		}
	}
}
