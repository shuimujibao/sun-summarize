package record.leetcode.editor.cn;

//给定一个包含大写字母和小写字母的字符串
// s ，返回 通过这些字母构造成的 最长的回文串 。
//
// 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
//
//
//
// 示例 1:
//
//
//输入:s = "abccccdd"
//输出:7
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
//
//
// 示例 2:
//
//
//输入:s = "a"
//输出:1
//
//
// 示例 3：
//
//
//输入:s = "aaaaaccc"
//输出:7
//
//
//
// 提示:
//
//
// 1 <= s.length <= 2000
// s 只由小写 和/或 大写英文字母组成
//
//
// Related Topics 贪心 哈希表 字符串 👍 583 👎 0

public class LongestPalindrome {
	public static void main(String[] args) {
		Solution solution = new LongestPalindrome().new Solution();
		solution.longestPalindrome("abccccdd");
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int longestPalindrome(String s) {
//			// 最大长度
//			int maxLength = 1;
//
//			// 索引位置
//			int index = 1;
//
//			while (index < s.length()) {
//
//				int leftPoint = index - 1;
//				int rightPoint = index + 1;
//
//				// 回文判断
//				while (leftPoint >= 0 && rightPoint < s.length()
//					&& s.charAt(leftPoint) == s.charAt(rightPoint)) {
//
//					leftPoint++;
//					rightPoint++;
//				}
//
//				// 更新最大长度
//				maxLength = rightPoint - leftPoint + 1;
//
//				index++;
//			}
//
//			return maxLength;

			int[] cnt = new int[58];
			for (char c : s.toCharArray()) {
				cnt[c - 'A'] += 1;
			}
			int ans = 0;
			for (int x : cnt) {
				// 字符出现的次数最多用偶数次。
				ans += x - (x & 1);
			}
			// 如果最终的长度小于原字符串的长度，说明里面某个字符出现了奇数次，
			// 那么那个字符可以放在回文串的中间，所以额外再加一。
			return ans < s.length() ? ans + 1 : ans;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
