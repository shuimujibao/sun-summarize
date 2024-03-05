package record.leetcode.editor.cn;

//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。
//
// 你可以对一个单词进行如下三种操作：
//
//
// 插入一个字符
// 删除一个字符
// 替换一个字符
//
//
//
//
// 示例 1：
//
//
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
//
//
// 示例 2：
//
//
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
//
//
//
//
// 提示：
//
//
// 0 <= word1.length, word2.length <= 500
// word1 和 word2 由小写英文字母组成
//
// Related Topics 字符串 动态规划
// 👍 3256 👎 0

public class EditDistance {
	public static void main(String[] args) {
		Solution solution = new EditDistance().new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int minDistance(String s1, String s2) {
			int m = s1.length(), n = s2.length();
			int[][] dp = new int[m + 1][n + 1];
			// base case
			for (int i = 1; i <= m; i++)
				dp[i][0] = i;
			for (int j = 1; j <= n; j++)
				dp[0][j] = j;
			// 自底向上求解
			for (int i = 1; i <= m; i++)
				for (int j = 1; j <= n; j++)
					if (s1.charAt(i - 1) == s2.charAt(j - 1))
						dp[i][j] = dp[i - 1][j - 1];
					else
						dp[i][j] = min(
							dp[i - 1][j] + 1,
							dp[i][j - 1] + 1,
							dp[i - 1][j - 1] + 1
						);
			// 储存着整个 s1 和 s2 的最小编辑距离
			return dp[m][n];
		}

		int min(int a, int b, int c) {
			return Math.min(a, Math.min(b, c));
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
