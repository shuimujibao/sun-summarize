package record;


import java.util.Arrays;

/**
 * 给个数字，给个数字数组，从数字数组里拼一个小于数字的最大值
 *
 * @description: 数字组合
 * @author: xy.sun06
 * @create: 2024-03-22 11:18
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class NumCombination {
	public static void main(String[] args) {
		int target = 25;
		int[] nums = new int[]{3, 2, 1};

		int maxValueCombination = NumCombination.getMaxValueCombination(target, nums);

		System.out.println(maxValueCombination);
	}

	/**
	 * 获取小于目标值的最大值组合
	 * 贪心算法
	 * <p>
	 * 1.数组降序排列，从最大值开始比较
	 * 2.高位越大，组合值越大
	 * （1）由低位开始交换，将组合值变小
	 * （2）由低位开始交换，将组合值变小（直至低位值移动至第二位，说明当前位数不存在比目标值小的数）
	 * （3）此时将原始值第二位交换至第一位，循环上一步
	 * （4）上述操作不存在比目标值小的值，则移除一位循环上述操作，直至找到期望值
	 *
	 * @param target 目标值
	 * @param nums   数据源
	 * @return int
	 */
	public static int getMaxValueCombination(int target, int[] nums) {
		Arrays.sort(nums);

		Integer currentValue = nums[0];

		for (int i = 0; i < nums.length; i++) {
			System.out.println(currentValue);
			currentValue = nums[i] * numberOfDigits(i) + currentValue;
		}

		return currentValue;
	}

	/**
	 * 获取位数单位
	 *
	 * @param i 位数
	 * @return 位数单位
	 */
	private static int numberOfDigits(int i) {
		int digits = 1;
		while (i > 0) {
			digits = digits * 10;
			i--;
		}
		return digits;
	}
}
