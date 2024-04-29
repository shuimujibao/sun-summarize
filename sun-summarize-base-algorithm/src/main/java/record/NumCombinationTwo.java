package record;


import java.util.LinkedList;

/**
 * @description: 数组组合
 * @author: xy.sun06
 * @create: 2024-03-22 12:00
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class NumCombinationTwo {
	public static void main(String[] args) {
		int target = 25;
		int[] nums = new int[]{3, 2, 1};

		int maxValueCombination = NumCombination.getMaxValueCombination(target, nums);

		System.out.println(maxValueCombination);
	}




	/**
	 * 记录「路径」
	 */
	private static LinkedList<Integer> track = new LinkedList<>();

	/**
	 * 获取小于目标值的最大值组合
	 * 回溯算法
	 *
	 * @param target 目标值
	 * @param nums   数据源
	 * @return int
	 */
	public static int backtrack(int target, int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			track.add(nums[i]);
			backtrack(target, nums);
			track.removeLast();
		}
		return 0;
	}
}
