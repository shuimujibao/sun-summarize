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

public class MaximumProductSubarray {
	public static void main(String[] args) {
		Solution solution = new MaximumProductSubarray().new Solution();

		int[] nuns = {2,3,-2,4};
		int maxValue = solution.maxProduct(nuns);
		System.out.println(maxValue);

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		/**
		 * 动态转换方程
		 * i 为数组开始位置，j为数组中止位置
		 * dp[i][j] = dp[i-1][j] * nums[i-1]
		 * <p>
		 * dp[i][j] = dp[i][j-1] * nums[j-1]
		 *
		 * @param nums 数据源
		 * @return
		 */
		public int maxProduct(int[] nums) {
			// 乘积最大值
			int maxValue = -Integer.MAX_VALUE;

			// 备忘录
			int[][] dp = new int[nums.length][nums.length];

			// 初始化
			for (int i = 0; i < nums.length; i++) {
				dp[i][i] = nums[i];
			}

			// 动态规划
			for (int i = 0; i < nums.length; i++) {
				// 乘积最大值，解决最大值为一个值问题
				maxValue = Math.max(nums[i], maxValue);

				// 穷举
				for (int j = i+1; j < nums.length; j++) {
					// 获取数组从 i~j的乘积和
					dp[i][j] = dp[i][j - 1] * nums[j];

					// 判断此时最大乘积和
					maxValue = Math.max(dp[i][j], maxValue);
				}
			}

			return maxValue;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
