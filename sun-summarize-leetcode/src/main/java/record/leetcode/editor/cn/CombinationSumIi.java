package record.leetcode.editor.cn;

//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用 一次 。
//
// 注意：解集不能包含重复的组合。
//
//
//
// 示例 1:
//
//
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
//
// 示例 2:
//
//
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//]
//
//
//
// 提示:
//
//
// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30
//
// Related Topics 数组 回溯
// 👍 1519 👎 0

import java.util.*;

public class CombinationSumIi {
	public static void main(String[] args) {
		Solution solution = new CombinationSumIi().new Solution();

		int[] arr = new int[]{2, 5, 2, 1, 2};
		int target = 5;
		solution.combinationSum2(arr, target);
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

		public List<List<Integer>> combinationSum2(int[] candidates, int target) {

			// 排序
			Arrays.sort(candidates);

			// 回溯
			backTracking(0, candidates, target);

			// 返回结果集
			return allResult;
		}

		void backTracking(int start, int[] candidates, int target) {
			// 路径和
			int sum = path.stream().mapToInt(Integer::intValue).sum();

			// 中止条件
			if (sum == target) {
				allResult.add(new LinkedList<>(path));
				return;
			}

			if (sum > target) {
				return;
			}

			// 回溯
			for (int i = start; i < candidates.length; i++) {

				if (i != start && candidates[i] == candidates[i - 1]) {
					continue;
				}
				path.add(candidates[i]);
				backTracking(i + 1, candidates, target);
				path.removeLast();
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
