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

		System.out.println(solution.longestPalindrome("cbbd"));

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		/**
		 * 回文字符串描述：
		 * 起始位置: row
		 * 中止位置: column
		 * <p>
		 * 1.起始位置与中止位置相同，必回文
		 * 2.若dp[i-1][j+1]为回文字符串，当 s[i] = s[j],则dp[i][j]为回文字符串
		 */
		//    ||    0  ||   1   ||    2   ||   3   ||  4  ||
		// =================================================
		//  0 || true  ||（0，1）||（0，2） || (0，3)||(0，4)||
		// =================================================
		//  1 ||       || true  || (1,2)  || (1,3) ||(1,4)||
		// =================================================
		//  2 ||       ||       ||  true  || (2,3) ||(2,3)||
		// =================================================
		//  3 ||       ||       ||        ||  true ||(3,3)||
		// =================================================
		//  4 ||       ||       ||        ||       || true||
		// =================================================
		public String longestPalindrome(String s) {
			// 非空判断
			if (s == null || s.isEmpty()) {
				return s;
			}
			// 字符串长度
			int length = s.length();
			// 回文字符串最大长度
			int maxLength = 0;
			// 开始为止
			int begin = 0;

			// 状态存储
			Boolean[][] dp = new Boolean[length][length];

			// 起始位置与中止位置相同，必回文
			for (int i = 0; i < length; i++) {
				dp[i][i] = true;
			}

			for (int row = 1; row < s.length(); row++) {
				for (int column = 0; column < s.length(); column++) {
					if (s.charAt(row) != s.charAt(column)) {
						dp[row][column] = false;
					} else {

						if (column - row < 3) {
							// “aa”等情况
							dp[row][column] = true;
						} else {
							// 动态转移方程
							dp[row][column] = dp[row + 1][row - 1];
						}
					}
					// 更新当前最大回文串长度
					if (dp[row][column] && column - row + 1 > maxLength) {
						maxLength = column - row + 1;
						begin = row;
					}
				}
			}
			return s.substring(begin, begin + maxLength);
		}
	}
//leetcode smit region end(Prohibit modification and deletion)

}
