package dynamicprogram;

import java.util.Arrays;

/**
 * @description: 子集背包问题
 * @author: xy.sun06
 * @create: 2024-08-19 10:47
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class SubsetKnapsack {

	/**
	 * 输入一个集合，返回是否能够分割成和相等的两个子集
	 * 转化为背包问题
	 * 给一个可装载重量为 sum / 2 的背包和 N 个物品，每个物品的重量为 nums[i]。现在让你装物品，是否存在一种装法，能够恰好将背包装满？
	 *
	 * @param nums
	 * @return
	 */
	boolean canPartition(int[] nums) {
		// 数组和
		int sum = Arrays.stream(nums).sum();

		// 和为奇数，两个数组不可能等分
		if (sum % 2 != 0) {
			return false;
		}

		// 背包容量为 sum/2
		// 物品数量 n,第i个物品价值为nums[i]
		int n = nums.length;

		Boolean[][] dp = new Boolean[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {
			dp[i][0] = true;
		}

		// 自底向上穷举
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j - nums[i - 1] < 0) {
					// 背包容量不足，不能装入第 i 个物品
					dp[i][j] = dp[i - 1][j];
				} else {
					// 装入或不装入背包
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
				}
			}
		}

		return dp[n][sum];
	}

	/**
	 * 进一步优化
	 * <p>
	 * 注意到 dp[i][j] 都是通过上一行 dp[i-1][..] 转移过来的，之前的数据都不会再使用了。
	 * 其实这段代码和之前的解法思路完全相同，只在一行 dp 数组上操作，i 每进行一轮迭代，dp[j] 其实就相当于 dp[i-1][j]，所以只需要一维数组就够用了。
	 *
	 * 唯一需要注意的是 j 应该从后往前反向遍历，因为每个物品（或者说数字）只能用一次，以免之前的结果影响其他的结果。
	 *
	 * @param nums
	 * @return
	 */
	public boolean canPartition2(int[] nums) {
		// 数组和
		int sum = Arrays.stream(nums).sum();

		// 和为奇数时，不可能划分成两个和相等的集合
		if (sum % 2 != 0) return false;
		int n = nums.length;
		sum = sum / 2;

		boolean[] dp = new boolean[sum + 1];

		// base case
		dp[0] = true;

		for (int i = 0; i < n; i++) {
			for (int j = sum; j >= 0; j--) {
				if (j - nums[i] >= 0) {
					dp[j] = dp[j] || dp[j - nums[i]];
				}
			}
		}
		return dp[sum];
	}
}
