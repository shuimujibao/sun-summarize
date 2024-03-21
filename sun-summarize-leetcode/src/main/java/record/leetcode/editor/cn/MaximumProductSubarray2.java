package record.leetcode.editor.cn;

//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
// 测试用例的答案是一个 32-位 整数。
//
//
//
// 示例 1:
//
//
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
//
//
// 示例 2:
//
//
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
//
//
//
// 提示:
//
//
// 1 <= nums.length <= 2 * 10⁴
// -10 <= nums[i] <= 10
// nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
//
//
// Related Topics 数组 动态规划 👍 2204 👎 0

public class MaximumProductSubarray2 {
	public static void main(String[] args) {
		Solution solution = new MaximumProductSubarray2().new Solution();

		int[] nuns = {2, 3, -2, 4};
		int maxValue = solution.maxProduct(nuns);
		System.out.println(maxValue);

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		/**
		 * 状态转移方程
		 * <p>
		 * dpMax[i]代表以第i个元素结尾子数组的乘积最大值
		 * dpMin[i]代表以第i个元素结尾子数组的乘积最小值
		 * <p>
		 * 根据数据摆渡，状态转移方程分为以下三种情况
		 * 1.全是正数
		 * dpMax[i] = dpMax[i-1]*num[i];
		 * 2.包含0
		 * dpMax[i] = Math.max(dpMax[i-1]*num[i],num[i])
		 * eg：dpMax[i-1] = 0，num[i] =3，则最大值为 3，而不是3*0；
		 * 3、包含负数
		 * （1）若num[i]为负数，dp[i] = dpMin[i-1]*num[i]
		 * （1）若num[i]为正数，dp[i] = dpMax[i-1]*num[i]
		 * <p>
		 * 综上所述当前问题动态转移方程为
		 * Math.max(Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]), nums[i]);
		 * 同时记录最小值
		 * Math.min(Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]), nums[i]);
		 *
		 * @param nums 数据源
		 * @return
		 */
		public int maxProduct(int[] nums) {
			// 乘积最大值
			int maxValue = nums[0];

			// 临界值处理,只有一个元素
			if (nums.length == 1) {
				return maxValue;
			}

			// 状态记录
			int[] dpMax = new int[nums.length];
			dpMax[0] = nums[0];
			int[] dpMin = new int[nums.length];
			dpMin[0] = nums[0];

			// 动态规划
			for (int i = 1; i < nums.length; i++) {
				dpMax[i] = Math.max(Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]), nums[i]);
				dpMin[i] = Math.min(Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]), nums[i]);
				maxValue = Math.max(dpMax[i], maxValue);
			}

			return maxValue;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
