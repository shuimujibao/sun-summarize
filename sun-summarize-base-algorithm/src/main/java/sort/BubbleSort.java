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

	public static void sort(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length - i; j++) {
				if (nums[i] > nums[j]) {
					Swap.handle(nums, i, j);
				}
			}
		}
	}
}
