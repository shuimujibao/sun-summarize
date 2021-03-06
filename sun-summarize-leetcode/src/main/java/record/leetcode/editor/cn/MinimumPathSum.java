package record.leetcode.editor.cn;

//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。
//
//
//
// 示例 1：
//
//
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
//
//
// 示例 2：
//
//
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 200
// 0 <= grid[i][j] <= 100
//
// Related Topics 数组 动态规划 矩阵
// 👍 1262 👎 0

public class MinimumPathSum {
	public static void main(String[] args) {
		Solution solution = new MinimumPathSum().new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int minPathSum(int[][] grid) {

			// ================解法一===============
			// 行数
			int row = grid[0].length - 1;

			// 列数
			int column = grid.length - 1;

			// 转化方程
			int[][] dp = new int[row][column];

			for (int i = 0; i <= row; i++) {
				for (int j = 0; j <= column; j++) {
					if (i == 0 && j == 0) {
						dp[0][0] = 1;
					} else if (i == 0) {
						dp[i][j] = dp[i][j - 1] + dp[i][j];
					} else if (j == 0) {
						dp[i][j] = dp[i - 1][j] + dp[i][j];
					} else {
						dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1] + grid[i][j]);
					}
				}
			}
			return dp[column][row];
			// ===============解法二================

//			// 检查
//			if (grid.length == 0 || grid[0].length == 0) {
//				return 0;
//			}
//			// 行
//			int row = grid.length;
//			// 列
//			int column = grid[0].length;
//
//			// 状态存储
//			int[] dp = new int[column];
//
//			// 遍历二维数组
//			for (int i = 0; i < row; i++) {
//				for (int j = 0; j < column; j++) {
//					if (j == 0) {
//						// 只能从上侧走到该位置
//						dp[j] = dp[j];
//					} else if (i == 0) {
//						// 只能从左侧走到该位置
//						dp[j] = dp[j - 1];
//					} else {
//						dp[j] = Math.min(dp[j - 1], dp[j]);
//					}
//					dp[j] += grid[i][j];
//				}
//			}
//			return dp[column - 1];

			// ===============解法三================
//			// 列
//			int column = grid[0].length;
//			// 状态存储
//			int[] dp = new int[column];
//			// 初始值
//			dp[0] = grid[0][0];
//
//			// 第一行数据和
//			for (int i = 1; i < column; i++) {
//				dp[i] = dp[i - 1] + grid[0][i];
//			}
//
//			// 二维数组遍历
//			for (int i = 1; i < grid.length; i++) {
//				// 第一列数据
//				dp[0] = dp[0] + grid[i][0];
//				for (int j = 1; j < column; j++) {
//					// 其他数据情况
//					dp[j] = Math.min(dp[j - 1] + grid[i][j], dp[j] + grid[i][j]);
//				}
//			}
//			return dp[column - 1];
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
