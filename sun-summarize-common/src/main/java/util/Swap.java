package util;

/**
 * Swap
 *
 * @summary util
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 贝壳找房（北京）科技有限公司
 * @since: 2022年04月21日 10:52:00
 */
public class Swap {

	/**
	 * 交换数组的两个元素
	 *
	 * @param nums 数组
	 * @param i    索引
	 * @param j    索引
	 */
	public static void handle(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}

