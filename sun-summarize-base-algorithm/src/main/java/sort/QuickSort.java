package sort;

import util.Swap;

/**
 * @description: 快速排序
 * @author: xy.sun06
 * @create: 2024-08-09 15:13
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class QuickSort {

	/**
	 * Java快速排序是一种高效的排序算法，它通过一个切分元素将数组分成两部分，然后递归地对这两部分进行排序。
	 * <p>
	 * 时间复杂度: 平均情况下，快速排序的时间复杂度为O(n log n)。
	 * 最坏情况下，即当输入数组已经排序好或接近排序好的情况下，快速排序的时间复杂度会退化为O(n^2)。
	 * 空间复杂度: 快速排序的空间复杂度取决于递归栈的深度，最优情况下为O(log n)（完全平衡的情况），最坏情况下为O(n)。
	 *
	 * @param arr  数组
	 * @param low  低位
	 * @param high 高位
	 */
	public static void sort(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}

		// 获取分区后的枢纽位置
		int pivotIndex = partition(arr, low, high);

		// 分别对枢纽左右两边的子数组进行递归排序
		sort(arr, low, pivotIndex - 1);
		sort(arr, pivotIndex + 1, high);
	}

	private static int partition(int[] arr, int low, int high) {
		// 选择数组的最后一个元素作为枢纽值
		int pivot = arr[high];
		int i = (low - 1);

		// 遍历数组，将小于枢纽值的元素放到左边，大于枢纽值的元素放到右边
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				Swap.handle(arr, i, j);
			}
		}

		// 将枢纽元素放到正确的位置
		Swap.handle(arr, i + 1, high);
		// 返回枢纽位置
		return i + 1;
	}

}
