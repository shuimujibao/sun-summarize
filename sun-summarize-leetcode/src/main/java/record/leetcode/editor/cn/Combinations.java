package record.leetcode.editor.cn;

//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
// 你可以按 任何顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
//
// 示例 2：
//
//
//输入：n = 1, k = 1
//输出：[[1]]
//
//
//
// 提示：
//
//
// 1 <= n <= 20
// 1 <= k <= n
//
// Related Topics 回溯
// 👍 1589 👎 0

import java.util.*;

public class Combinations {
	public static void main(String[] args) {
		Solution solution = new Combinations().new Solution();

		solution.combine(4, 2);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		/**
		 * 所有组合结果
		 */
		List<List<Integer>> allResult = new LinkedList<>();

		/**
		 * 单个结果
		 */
		Deque<Integer> path = new ArrayDeque<>();

		public List<List<Integer>> combine(int n, int k) {
			// 回溯遍历
			backTracking(1, n, k);

			// 返回所有结果
			return allResult;
		}

		/**
		 * 回溯
		 *
		 * @param start 遍历起始位置
		 * @param n     数据上限
		 * @param k     总数
		 */
		void backTracking(int start, int n, int k) {
			// 递归中止条件
			if (path.size() == k) {
				allResult.add(new ArrayList<>(path));
				return;
			}

			for (int i = start; i <= n; i++) {
				path.add(i);
				backTracking(i + 1, n, k);
				path.removeLast();
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
