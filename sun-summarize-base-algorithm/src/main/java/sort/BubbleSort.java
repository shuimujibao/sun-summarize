package sort;

import util.Swap;

/**
 * 冒泡排序
 *
 * @summary 平均时间复杂度O(n ^ 2) 最好情况O(n) 空间复杂度O(1) 稳定的排序
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 贝壳找房（北京）科技有限公司
 * @since: 2022年04月21日 10:49:00
 */
public class BubbleSort {
	/**
	 * 两两比较最大的放到最后
	 * 输入：3, 1, 6, 5，2
	 * <p>
	 * i=0
	 * 1, 3, 6, 5，2
	 * 1, 3, 6, 5，2
	 * 1, 3, 5, 6，2
	 * 1, 3, 5, 2，6
	 * <p>
	 * i=1
	 * 1, 3, 5, 2
	 * 1, 3, 5, 2
	 * 1, 3, 2, 5
	 * <p>
	 * i=2;
	 * 1, 3, 2
	 * 1, 2, 3
	 *
	 * @param nums 数组
	 */
	public static void sort(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length - i - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					Swap.handle(nums, j, j + 1);
				}
			}
		}
	}
}
