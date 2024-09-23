package record.leetcode.editor.cn;
//给你一个满足下述两条属性的 m x n 整数矩阵：
//
//
// 每行中的整数从左到右按非严格递增顺序排列。
// 每行的第一个整数大于前一行的最后一个整数。
//
//
// 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
//
//
// 示例 2：
//
//
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -10⁴ <= matrix[i][j], target <= 10⁴
//
//
// Related Topics数组 | 二分查找 | 矩阵
//
// 👍 959, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

public class SearchA2dMatrix {
	public static void main(String[] args) {
		Solution solution = new SearchA2dMatrix().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public boolean searchMatrix(int[][] matrix, int target) {

			int rows = matrix.length;
			int columns = matrix[0].length;

			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					if (matrix[i][j] == target) {
						return true;
					}
				}

			}
			return false;
		}


		public boolean searchMatrix2(int[][] matrix, int target) {
			int m = matrix.length, n = matrix[0].length;
			// 把二维数组映射到一维
			int left = 0, right = m * n - 1;
			// 前文讲的标准的二分搜索框架
			while (left <= right) {
				int mid = left + (right - left) / 2;
				if (get(matrix, mid) == target)
					return true;
				else if (get(matrix, mid) < target)
					left = mid + 1;
				else if (get(matrix, mid) > target)
					right = mid - 1;
			}
			return false;
		}

		// 通过一维坐标访问二维数组中的元素
		int get(int[][] matrix, int index) {
			// m行 示例3行
			int m = matrix.length;

			// n列 示例4列
			int n = matrix[0].length;

			// 计算二维中的横纵坐标
			// 示例 m * n个索引中即3 * 4 =12，求index = 8的坐标
			// i= 8/4 = 2;
			// j= 8%4 = 0;
			// index= 8 即matrix[i][j] = 即matrix[2][0]
			int i = index / n;
			int j = index % n;

			return matrix[i][j];
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
