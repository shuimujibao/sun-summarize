package record.leetcode.editor.cn;
//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
//
// 子数组是数组中元素的连续非空序列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,1], k = 2
//输出：2
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3], k = 3
//输出：2
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 2 * 10⁴
// -1000 <= nums[i] <= 1000
// -10⁷ <= k <= 10⁷
//
//
// Related Topics数组 | 哈希表 | 前缀和
//
// 👍 2405, 👎 0
//
//
//
//

public class SubarraySumEqualsK {
	public static void main(String[] args) {
		Solution solution = new SubarraySumEqualsK().new Solution();
		int[] nums = new int[]{1, 2, 1, 2, 1};
		int k = 3;
		solution.subarraySum(nums, k);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int subarraySum(int[] nums, int k) {
			// 前缀和
			int[] preSum = new int[nums.length];
			preSum[0] = nums[0];
			for (int i = 1; i < nums.length; i++) {
				preSum[i] = nums[i] + preSum[i - 1];
			}

			// 子数组和为k的个数
			int res = 0;

			// 遍历获取和为k的子数组
			for (int i = 0; i < nums.length; i++) {
				// 子数组只有一个值
				if (nums[i] == k) {
					res++;
				}

				// 子数组有多个值
				for (int j = i + 1; j < nums.length; j++) {
					int sum = preSum[j] - preSum[i] + nums[i];
					if (sum == k) {
						res++;
					}
				}
			}
			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
