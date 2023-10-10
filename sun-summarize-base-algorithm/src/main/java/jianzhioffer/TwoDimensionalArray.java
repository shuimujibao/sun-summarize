package jianzhioffer;

import java.util.Scanner;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年10月10日 13:39:00
 */
public class TwoDimensionalArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		int a = scanner.nextInt();

		int[][] nums = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		twoDimensionalArraySearch(9, nums);
	}

	private static void twoDimensionalArraySearch(int target, int[][] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				if (nums[i][j] == target) {
					System.out.println(nums[i][j]);
				}
			}
		}
	}
}
