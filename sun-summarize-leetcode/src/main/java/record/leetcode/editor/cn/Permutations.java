package record.leetcode.editor.cn;

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
// 示例 2：
//
//
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// nums 中的所有整数 互不相同
//
// Related Topics 数组 回溯
// 👍 2730 👎 0

import java.util.LinkedList;
import java.util.List;

public class Permutations {
	public static void main(String[] args) {
		Solution solution = new Permutations().new Solution();

		int[] nums = new int[]{1, 2, 3};

		solution.permute(nums);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		/**
		 * 结果集
		 */
		List<List<Integer>> res = new LinkedList<>();

		/**
		 * 记录「路径」
		 */
		LinkedList<Integer> track = new LinkedList<>();

		public List<List<Integer>> permute(int[] nums) {


			backtrack(nums, track);

			return res;
		}

		void backtrack(int[] nums, LinkedList<Integer> track) {

			// 中止条件
			if (track.size() == nums.length) {
				res.add(new LinkedList<>(track));
				return;
			}

			// 回溯
			for (int num : nums) {
				// 剪枝
				if (track.contains(num)) {
					continue;
				}

				// 路径选择
				track.add(num);
				backtrack(nums, track);
				track.removeLast();
			}

		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
