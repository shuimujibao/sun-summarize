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
// Related Topics数组 | 回溯
//
// 👍 2107, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	public static void main(String[] args) {
		Solution solution = new NQueens().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		private List<List<String>> res = new ArrayList<>();

		// 输入棋盘边长 n，返回所有合法的放置
		public List<List<String>> solveNQueens(int n) {
			// 每个字符串代表一行，字符串列表代表一个棋盘
			// '.' 表示空，'Q' 表示皇后，初始化空棋盘
			List<String> board = new ArrayList<>();

			// 初始化，等价于board.add(".".repeat(n)); JDK11
			int m = n;
			StringBuilder sb = new StringBuilder();
			while (m > 0) {
				sb.append(".");
				m--;
			}
			for (int i = 0; i < n; i++) {
				board.add(sb.toString());
			}
			backtrack(board, 0);
			return res;
		}

		// 路径：board 中小于 row 的那些行都已经成功放置了皇后
		// 选择列表：第 row 行的所有列都是放置皇后的选择
		// 结束条件：row 超过 board 的最后一行
		private void backtrack(List<String> board, int row) {
			// 触发结束条件
			if (row == board.size()) {
				res.add(new ArrayList<>(board));
				return;
			}

			int n = board.get(row).length();
			for (int col = 0; col < n; col++) {
				// 排除不合法选择
				if (!isValid(board, row, col)) {

					continue;
				}
				// 做选择
				char[] rowChars = board.get(row).toCharArray();
				rowChars[col] = 'Q';
				board.set(row, new String(rowChars));
				// 进入下一行决策
				backtrack(board, row + 1);
				// 撤销选择
				rowChars[col] = '.';
				board.set(row, new String(rowChars));
			}
		}

		// 是否可以在 board[row][col] 放置皇后？
		private boolean isValid(List<String> board, int row, int col) {
			int n = board.size();
			// 检查列是否有皇后互相冲突
			for (int i = 0; i <= row; i++) {
				if (board.get(i).charAt(col) == 'Q') {
					return false;
				}
			}
			// 检查右上方是否有皇后互相冲突
			for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
				if (board.get(i).charAt(j) == 'Q') {
					return false;
				}
			}
			// 检查左上方是否有皇后互相冲突
			for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
				if (board.get(i).charAt(j) == 'Q') {
					return false;
				}
			}
			return true;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
