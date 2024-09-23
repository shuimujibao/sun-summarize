package record.leetcode.editor.cn;
//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
//
//
//
//
//
// 示例 1:
//
//
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//
//
// 示例 2:
//
//
//输入: numRows = 1
//输出: [[1]]
//
//
//
//
// 提示:
//
//
// 1 <= numRows <= 30
//
//
// Related Topics数组 | 动态规划
//
// 👍 1179, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public static void main(String[] args) {
		Solution solution = new PascalsTriangle().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<List<Integer>> generate(int numRows) {
			List<List<Integer>> res = new ArrayList<>();
			if (numRows < 1) {
				return res;
			}
			// 先把第一层装进去作为 base case
			List<Integer> firstRow = new ArrayList<>();
			firstRow.add(1);
			res.add(firstRow);
			// 开始一层一层生成，装入 res
			for (int i = 2; i <= numRows; i++) {
				List<Integer> prevRow = res.get(res.size() - 1);
				res.add(generateNextRow(prevRow));
			}
			return res;
		}

		// 输入上一层的元素，生成并返回下一层的元素
		List<Integer> generateNextRow(List<Integer> prevRow) {
			List<Integer> curRow = new ArrayList<>();
			curRow.add(1);
			for (int i = 0; i < prevRow.size() - 1; i++) {
				curRow.add(prevRow.get(i) + prevRow.get(i + 1));
			}
			curRow.add(1);
			return curRow;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
