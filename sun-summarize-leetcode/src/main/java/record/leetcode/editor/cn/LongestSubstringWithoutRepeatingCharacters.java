package record.leetcode.editor.cn;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 104
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 字符串 滑动窗口
// 👍 7429 👎 0

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int lengthOfLongestSubstring(String s) {
			int maxLength = 0;
			int left = 0;
			int right = 0;
			int length = s.length();

			HashMap<Character, Integer> window = new HashMap<>();

			while (right < length) {
				char rightChara = s.charAt(right);
				right++;

				// 滑动窗口新增当前字符
				window.put(rightChara, window.getOrDefault(rightChara, 0) + 1);

				while (window.get(rightChara) > 1 && left < right) {
					char leftChara = s.charAt(left);
					// 滑动窗口移除当前字符
					window.put(leftChara, window.get(leftChara) - 1);
					left++;
				}

				// 更新最大子串长度
				maxLength = Math.max(maxLength, right - left);
			}

			return maxLength;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
