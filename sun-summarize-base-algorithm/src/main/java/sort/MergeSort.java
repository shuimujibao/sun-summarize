package sort;

/**
 * @description: 归并排序
 * @author: xy.sun06
 * @create: 2024-08-09 15:25
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class MergeSort {
	private void mergeSortHelper(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		int mid = left + (right - left) / 2;
		mergeSortHelper(arr, left, mid);
		mergeSortHelper(arr, mid + 1, right);
		merge(arr, left, mid, right);
	}

	private void merge(int[] arr, int left, int mid, int right) {
		int[] temp = new int[right - left + 1];
		int i = left;
		int j = mid + 1;
		int k = 0;

		while (i <= mid && j <= right) {
			temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
		}

		while (i <= mid) {
			temp[k++] = arr[i++];
		}

		while (j <= right) {
			temp[k++] = arr[j++];
		}

		for (i = 0; i < k; i++) {
			arr[left + i] = temp[i];
		}
	}
}
