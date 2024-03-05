package record.leetcode.editor.cn;

//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
//
//
// 注意：
//
//
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。
//
//
//
//
// 示例 1：
//
//
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
//
//
// 示例 2：
//
//
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
//
//
// 示例 3:
//
//
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。
//
//
//
// 提示：
//
//
// m == s.length
// n == t.length
// 1 <= m, n <= 105
// s 和 t 由英文字母组成
//
//
//
//进阶：你能设计一个在 o(m+n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口
// 👍 2786 👎 0

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Objects;

public class MinimumWindowSubstring {
	public static void main(String[] args) {
		Solution solution = new MinimumWindowSubstring().new Solution();

		String s = "ab";
		String t = "A";



		System.out.println(solution.minWindow(s, t));

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public String minWindow(String s, String t) {

			if (s.length() < t.length()) {
				return "";
			}

			if (s.length() == 1 && t.length() == 1) {
				if (s.equals(t)) {
					return s;
				} else {
					return "";
				}
			}

			// 记录窗口中字符及出现次数
			HashMap<String, Integer> windows = new HashMap<>();

			// 记录目标字符及出现次数
			HashMap<String, Integer> needs = new HashMap<>();

			for (char c : t.toCharArray()) {
				String value = String.valueOf(c);
				needs.put(value, needs.getOrDefault(value, 0) + 1);
			}

			// 最短字符串
			String minStr = s;

			// 滑动窗口指针
			int leftPoint = 0;
			int rightPoint = 1;

			// 右指针走到结尾，则遍历结束
			while (rightPoint < s.length()) {

				// 统计临时窗口中的字符串
				String tempStr = s.substring(leftPoint, rightPoint);

				for (char c : tempStr.toCharArray()) {
					String value = String.valueOf(c);
					windows.put(value, windows.getOrDefault(value, 0) + 1);
				}

				// 如果当前窗口值不覆盖目标字符串，则右指针继续移动
				while (rightPoint < s.length() && !judge(windows, needs)) {

					windows.put(String.valueOf(s.charAt(rightPoint)),
						windows.getOrDefault(String.valueOf(s.charAt(rightPoint)), 0) + 1);

					rightPoint++;
				}


				// 左指针向右移动
				while (leftPoint < rightPoint && judge(windows, needs)) {

					Integer nums = windows.get(String.valueOf(s.charAt(leftPoint)));

					if (nums - 1 == 0) {
						windows.remove(String.valueOf(s.charAt(leftPoint)));
					} else {
						windows.put(String.valueOf(s.charAt(leftPoint)), nums - 1);
					}

					++leftPoint;
				}

				// 若覆盖，则左指针移动，并更新最小子序列
				minStr = minStr.length() > s.substring(leftPoint, rightPoint).length() ?
					s.substring(leftPoint - 1, rightPoint) : minStr;

				// 清空窗口
				windows = new HashMap<>();
			}
			return minStr;
		}


		/**
		 * 判断窗口中的字符串是否覆盖目标字符串
		 *
		 * @param windows 窗口中字符及出现次数
		 * @param needs   目标字符及出现次数
		 * @return Boolean
		 */
		private Boolean judge(HashMap<String, Integer> windows, HashMap<String, Integer> needs) {
			for (String str : needs.keySet()) {

				if (Objects.isNull(windows.get(str))) {
					return false;
				}

				if (windows.get(str) < (needs.get(str))) {
					return false;
				}
			}
			return true;
		}
	}
//leetcode submit regionnd(Prohibit modification and deletion)

}
