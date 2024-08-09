package sort;

import java.util.Arrays;

/**
 * @description: 测试排序
 * @author: xy.sun06
 * @create: 2024-08-09 14:59
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class TestSort {
	public static void main(String[] args) {
		int[] originArr = new int[]{3, 1, 5, 6, 1, 7, 10, 9};
		QuickSort.sort(originArr, 0, originArr.length - 1);
		System.out.println(Arrays.toString(originArr));
	}
}
