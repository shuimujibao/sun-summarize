package record.leetcode.editor.cn;

//斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
//
//
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
//
//
// 给定 n ，请计算 F(n) 。
//
// 答案需要取模 1e9+7(1000000007) ，如计算初始结果为：1000000008，请返回 1。
//
//
//
// 示例 1：
//
//
//输入：n = 2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
//
//
// 示例 2：
//
//
//输入：n = 3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
//
//
// 示例 3：
//
//
//输入：n = 4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
//
//
//
//
// 提示：
//
//
// 0 <= n <= 100
//
//
//
// Related Topics 记忆化搜索 数学 动态规划
// 👍 526 👎 0

import java.time.Duration;
import java.util.Date;

public class FeiBoNaQiShuLieLcof {
	public static void main(String[] args) {
		Solution solution = new FeiBoNaQiShuLieLcof().new Solution();

		Date start = new Date();
		System.out.println(solution.fib(40));
		Date end = new Date();

		long diffInMillies = Duration.between(start.toInstant(), end.toInstant()).toMillis();

		System.out.println("耗时：" + diffInMillies);
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	class Solution {
		/**
		 * 递归获取
		 */
		public int fib(int n) {
			if (n == 0) {
				return 0;
			}

			if (n == 1) {
				return 1;
			}

			return fib(n - 1) + fib(n - 2);
		}

		/**
		 * 自顶向下，使用备忘录获取
		 */
		int fib2(int N) {
			// 备忘录全初始化为 0
			int[] memo = new int[N + 1];
			// 进行带备忘录的递归
			return dp(memo, N);
		}

		// 带着备忘录进行递归
		int dp(int[] memo, int n) {
			// base case
			if (n == 0 || n == 1) {
				return n;
			}
			// 已经计算过，不用再计算了
			if (memo[n] != 0) {
				return memo[n];
			}
			memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
			return memo[n];
		}

		/**
		 * 自底向上
		 */
		int fib3(int N) {
			if (N == 0) {
				return 0;
			}
			int[] dp = new int[N + 1];

			// base case
			dp[0] = 0;
			dp[1] = 1;

			// 状态转移
			for (int i = 2; i <= N; i++) {
				dp[i] = dp[i - 1] + dp[i - 2];
			}

			return dp[N];
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
