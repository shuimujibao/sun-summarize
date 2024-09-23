package zijie.six;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @description: 区间合并
 * <p>
 * 题目描述
 * 给定一堆左右闭合的区间，要求对重叠的区间进行合并，返回合并后的区间段。
 * 例如:[9, 10],[1,4],[3,6],[8,12]
 * 那么合并后的区间段为:[1,6]，[8,12]
 * @author: xy.sun06
 * @create: 2024-07-26 09:46
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class WriteExamTwo {

	public static void main(String[] args) {
		int[][] arr = {{9, 10}, {1, 4}, {3, 6}, {8, 12}};

		int[][] merge = WriteExamTwo.merge(arr);


	}

	/**
	 * 区间合并--（线段合并）
	 * <p>
	 * // 一共多少个区间
	 * int intervalNums = intervals.length;
	 * // 第一个区间的值 [9,10]
	 * int[] interval = intervals[0];
	 *
	 * @param intervals 区间集合
	 * @return 合并后结果
	 */
	public static int[][] merge(int[][] intervals) {
		// 按区间的 start 升序排列
		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

		// 合并后区间
		LinkedList<int[]> res = new LinkedList<>();
		res.add(intervals[0]);

		// 遍历所有区间
		for (int i = 1; i < intervals.length; i++) {
			// 当前区间
			int[] curr = intervals[i];

			// 获取合并后最后一个区间
			int[] last = res.getLast();

			// 存在区间合并
			if (curr[0] <= last[1]) {
				last[1] = Math.max(last[1], curr[1]);
			} else {
				// 处理下一个待合并区间
				res.add(curr);
			}
		}

		return res.toArray(new int[0][0]);
	}
}
