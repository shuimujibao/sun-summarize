package record.leetcode.editor.cn;

//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//
//
// 示例 2：
//
//
//输入：nums = [0]
//输出：[[],[0]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// nums 中的所有元素 互不相同
//
//
// Related Topics 位运算 数组 回溯 👍 2256 👎 0

import java.util.*;

public class Subsets {
	public static void main(String[] args) {
		Solution solution = new Subsets().new Solution();

		int[] arr = new int[]{1, 2, 3};

		List<List<Integer>> subsets = solution.subsets(arr);

		System.out.println(subsets);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		/**
		 * 结果集
		 */
		public List<List<Integer>> result = new LinkedList<>();

		/**
		 * 单个结果
		 */
		LinkedList<Integer> path = new LinkedList<>();

		public List<List<Integer>> subsets(int[] nums) {
			backTrack(0, nums);

			return result;
		}

		public void backTrack(int startIndex, int[] nums) {
			// 中止条件
			result.add(new LinkedList<>(path));

			// 回溯
			for (int i = startIndex; i < nums.length; i++) {
				path.add(nums[i]);
				backTrack(i + 1, nums);
				path.removeLast();
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
