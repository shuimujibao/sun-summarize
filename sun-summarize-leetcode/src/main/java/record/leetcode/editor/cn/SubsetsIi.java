package record.leetcode.editor.cn;

//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
//
//
//
//
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
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
//
//
// Related Topics 位运算 数组 回溯 👍 1198 👎 0

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SubsetsIi {
	public static void main(String[] args) {
		Solution solution = new SubsetsIi().new Solution();

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
		Deque<Integer> path = new ArrayDeque<>();

		public List<List<Integer>> subsetsWithDup(int[] nums) {
			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
