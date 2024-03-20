package record.leetcode.editor.cn;

//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 子数组 是数组中的一个连续部分。
//
//
//
// 示例 1：
//
//
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//
//
// 示例 2：
//
//
//输入：nums = [1]
//输出：1
//
//
// 示例 3：
//
//
//输入：nums = [5,4,-1,7,8]
//输出：23
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
//
//
//
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
// Related Topics 数组 分治 动态规划
// 👍 4858 👎 0

public class MaximumSubarray {
	public static void main(String[] args) {
		Solution solution = new MaximumSubarray().new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int maxSubArray(int[] nums) {
			if (nums == null || nums.length == 0) {
				return 0;
			}


			int preNum = nums[0];

			int maxSum = preNum;

			for (int i = 1; i < nums.length; i++) {
				preNum = preNum > 0 ? preNum + nums[i] : nums[i];
				maxSum = Math.max(preNum, maxSum);
			}

			return maxSum;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
