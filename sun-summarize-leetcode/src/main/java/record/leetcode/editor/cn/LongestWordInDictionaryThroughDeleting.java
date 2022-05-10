package record.leetcode.editor.cn;

//给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
//
//
// 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。
//
//
//
// 示例 1：
//
//
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
//
//
// 示例 2：
//
//
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// 1 <= dictionary.length <= 1000
// 1 <= dictionary[i].length <= 1000
// s 和 dictionary[i] 仅由小写英文字母组成
//
// Related Topics 数组 双指针 字符串 排序
// 👍 300 👎 0

import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
	public static void main(String[] args) {
		Solution solution = new LongestWordInDictionaryThroughDeleting().new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public String findLongestWord(String s, List<String> dictionary) {
			String longestWord = "";
			for (String target : dictionary) {
				int l1 = longestWord.length();
				int l2 = target.length();
				if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
					continue;
				}
				if (isSubstr(s, target)) {
					longestWord = target;
				}
			}
			return longestWord;
		}

		private boolean isSubstr(String s, String target) {
			int i = 0;
			int j = 0;
			while (i < s.length() && j < target.length()) {
				if (s.charAt(i) == target.charAt(j)) {
					j++;
				}
				i++;
			}
			return j == target.length();
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
