package xiaomi.forth;

/**
 * @description:
 * @author: xy.sun06
 * @create: 2024-08-28 17:59
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class WriteExam {

	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3, 3, 3, 3, 4};
		WriteExam writeExam = new WriteExam();
		int findk = writeExam.findk(arr, 3);
		System.out.println(findk);
	}

	public int findk(int[] arr, int k) {
		int left = 0;
		int right = arr.length;
		// k出现的最左边位置
		int lowFarthest = 0;
		while (left <= right) {
			int middle = (right - left) / 2 + left;
			if (arr[middle] >= k) {
				lowFarthest = middle;
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}

		// k出现的最右边位置
		int fastRecent = 0;

		left = 0;
		right = arr.length;
		while (left <= right) {
			int middle = (right - left) / 2 + left;
			if (arr[middle] <= k) {
				fastRecent = middle;
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		return fastRecent - lowFarthest + 1;
	}
}
