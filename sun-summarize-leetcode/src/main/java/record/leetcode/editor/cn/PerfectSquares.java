package record.leetcode.editor.cn;
//给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
//
//
//
//
// 示例 1：
//
//
//输入：n = 12
//输出：3
//解释：12 = 4 + 4 + 4
//
// 示例 2：
//
//
//输入：n = 13
//输出：2
//解释：13 = 4 + 9
//
//
//
// 提示：
//
//
// 1 <= n <= 10⁴
//
//
// Related Topics广度优先搜索 | 数学 | 动态规划
//
// 👍 2001, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

import org.bouncycastle.util.Arrays;

public class PerfectSquares {
	public static void main(String[] args) {
		Solution solution = new PerfectSquares().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int numSquares(int n) {
			// 定义：和为 i 的平方数的最小数量是 dp[i]
			int[] dp = new int[n + 1];
			Arrays.fill(dp, Integer.MAX_VALUE);
			// base case
			dp[0] = 0;
			// 状态转移方程
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j * j <= i; j++) {
					// i - j * j 只要再加一个平方数 j * j 即可凑出 i
					dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
				}
			}
			return dp[n];
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
