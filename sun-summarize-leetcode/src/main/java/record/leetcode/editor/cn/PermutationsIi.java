package record.leetcode.editor.cn;

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
//
//
// Related Topics 数组 回溯 👍 1548 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsIi {
	public static void main(String[] args) {
		Solution solution = new PermutationsIi().new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		LinkedList<Integer> path = new LinkedList<>();

		List<List<Integer>> result = new ArrayList<>();
		boolean[] used;

		public List<List<Integer>> permuteUnique(int[] nums) {
			Arrays.sort(nums);
			dfs(nums);
			return result;
		}

		void dfs(int[] nums) {
			if (path.size() == nums.length) {
				result.add(new LinkedList<>(path));
			}

			for (int i = 0; i < nums.length; i++) {
				if (used[i]) {
					continue;
				}

				if (i > 0 && (nums[i - 1] == nums[i]) && !used[i - 1]) {
					continue;
				}

				path.add(nums[i]);
				used[i] = true;
				dfs(nums);
				path.removeLast();
				used[i] = false;
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)
}
