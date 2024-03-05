package record.leetcode.editor.cn;

//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回 -1 。
//
//
//
// 示例 1：
//
//
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。
//
//
// 示例 2：
//
//
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
//
//
//
//
// 提示：
//
//
// 1 <= haystack.length, needle.length <= 104
// haystack 和 needle 仅由小写英文字符组成
//
// Related Topics 双指针 字符串 字符串匹配
// 👍 2133 👎 0

public class FindTheIndexOfTheFirstOccurrenceInAString {
	public static void main(String[] args) {
		Solution solution = new FindTheIndexOfTheFirstOccurrenceInAString().new Solution();

		String haystack = "sadbutsad";
		String needle = "sad";
		System.out.println(solution.strStr(haystack, needle));

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int strStr(String haystack, String needle) {
			int haystackPoint = 0;

			int needleLength = needle.length();

			while (haystackPoint < haystack.length()) {

				int partStrLength = haystackPoint + needleLength;

				if (partStrLength > haystack.length()) {
					return -1;
				}

				String partStr = haystack.substring(haystackPoint, partStrLength);

				if (isSameStr(partStr, needle)) {
					return haystackPoint;
				}


				haystackPoint++;
			}

			return -1;
		}

		private boolean isSameStr(String str1, String str2) {
			return str1.equals(str2);
		}


		/**
		 * 暴力破解法
		 *
		 * @param ts 主串
		 * @param ps 模式串
		 * @return 如果找到，返回在主串中第一个字符出现的下标，否则为-1
		 */
		public int bf(String ts, String ps) {

			char[] t = ts.toCharArray();

			char[] p = ps.toCharArray();

			int i = 0; // 主串的位置

			int j = 0; // 模式串的位置

			while (i < t.length && j < p.length) {

				if (t[i] == p[j]) { // 当两个字符相同，就比较下一个

					i++;

					j++;

				} else {

					i = i - j + 1; // 一旦不匹配，i后退

					j = 0; // j归0

				}

			}

			if (j == p.length) {

				return i - j;

			} else {

				return -1;

			}

		}

		/**
		 * kmp解法
		 *
		 * @param ts 主串
		 * @param ps 模式串
		 * @return 如果找到，返回在主串中第一个字符出现的下标，否则为-1
		 */
		public int KMP(String ts, String ps) {

			char[] t = ts.toCharArray();

			char[] p = ps.toCharArray();

			int i = 0; // 主串的位置

			int j = 0; // 模式串的位置

			int[] next = getNext(ps);

			while (i < t.length && j < p.length) {

				if (j == -1 || t[i] == p[j]) { // 当j为-1时，要移动的是i，当然j也要归0

					i++;

					j++;

				} else {
					// i不需要回溯了

					// i = i - j + 1;

					j = next[j]; // j回到指定位置

				}

			}

			if (j == p.length) {

				return i - j;

			} else {

				return -1;

			}

		}

		public int[] getNext(String ps) {
			char[] p = ps.toCharArray();

			int[] next = new int[p.length];

			next[0] = -1;

			int j = 0;

			int k = -1;

			while (j < p.length - 1) {

				if (k == -1 || p[j] == p[k]) {

					if (p[++j] == p[++k]) { // 当两个字符相等时要跳过

						next[j] = next[k];

					} else {

						next[j] = k;

					}

				} else {

					k = next[k];

				}

			}

			return next;

		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}
