package jianzhioffer;

/**
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年10月09日 17:20:00
 */
public class RepeatNum {

	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 2, 4};
		search(nums);
	}


	private static void search(int[] nums) {
		for (int value : nums) {

			for (int num : nums) {

				if (value == num) {
					System.out.println(value);
				}
			}
		}
	}
}
