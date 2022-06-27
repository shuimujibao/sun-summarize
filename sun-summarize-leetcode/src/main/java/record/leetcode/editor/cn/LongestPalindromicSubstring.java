package record.leetcode.editor.cn;

//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母组成
//
// Related Topics 字符串 动态规划
// 👍 5120 👎 0

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		Solution solution = new LongestPalindromicSubstring().new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public String longestPalindrome(String s) {

			if (s == null || s.length() < 1) {
				return s;
			}

			int length = s.length();

			boolean[][] dp = new boolean[length - 1][length - 1];

			for (int i = 0; i < length; i++) {
				dp[i][i] = true;
			}

			int maxLen = 0;
			int begin = 0;

			for (int column = 1; column < length; column++) {
				for (int row = 0; row < length; row++) {
					if (s.charAt(row) != s.charAt(column)) {
						dp[row][column] = false;
					} else {
						if (column - row < 3) {
							dp[row][column] = true;
						} else {
							dp[row][column] = dp[row + 1][column - 1];
						}
					}

					if (dp[row][column] && column - row + 1 > maxLen) {
						maxLen = column - row + 1;
						begin = row;
					}
				}
			}

			return s.substring(begin, begin + maxLen);
		}
	}
//leetcode smit region end(Prohibit modification and deletion)

}
