package record.leetcode.editor.cn;

//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
//
//
//
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
//
//
// 示例 1：
//
//
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：[["Q"]]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 9
//
//
//
// Related Topics 数组 回溯
// 👍 1999 👎 0

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	public static void main(String[] args) {
		Solution solution = new NQueens().new Solution();

		solution.solveNQueens(4);

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		List<List<String>> result = new ArrayList<>();

		public List<List<String>> solveNQueens(int n) {
			// 初始化n*n棋盘
			int[][] board = new int[n][n];

			backtrack(board, 0);

			return result;
		}

		// 路径：board 中小于 row 的那些行都已经成功放置了皇后
		// 选择列表：第 row 行的所有列都是放置皇后的选择
		// 结束条件：row 超过 board 的最后一行
		void backtrack(int[][] board, int row) {
			// 触发结束条件
			if (row == board.length) {
				result.add(null);
				return;
			}

			// 获取总行数
			int n = board[row].length;

			// 处理每行中的每一列
			for (int col = 0; col < n; col++) {
				// 排除不合法选择
				if (!isValid(board, row, col))
					continue;
				// 做选择
				board[row][col] = 'Q';
				// 进入下一行决策
				backtrack(board, row + 1);
				// 撤销选择
				board[row][col] = '.';
			}
		}

		/* 是否可以在 board[row][col] 放置皇后？ */
		boolean isValid(int[][] board, int row, int col) {
			int n = board.length;
			// 检查列是否有皇后互相冲突
			for (int i = 0; i < n; i++) {
				if (board[i][col] == 'Q')
					return false;
			}
			// 检查右上方是否有皇后互相冲突
			for (int i = row - 1, j = col + 1;
				 i >= 0 && j < n; i--, j++) {
				if (board[i][j] == 'Q')
					return false;
			}
			// 检查左上方是否有皇后互相冲突
			for (int i = row - 1, j = col - 1;
				 i >= 0 && j >= 0; i--, j--) {
				if (board[i][j] == 'Q')
					return false;
			}
			return true;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
