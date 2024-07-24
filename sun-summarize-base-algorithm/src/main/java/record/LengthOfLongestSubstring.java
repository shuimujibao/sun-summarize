package record;

import java.util.HashMap;
import java.util.Objects;

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
public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		String s = "abcabcbb";
		int search = search(s);
	}

	public static int search(String s) {
		// 窗口
		HashMap<Character, Integer> window = new HashMap<>();

		// 最大长度
		int maxLength = 0;

		// 待处理数据
		char[] charArray = s.toCharArray();

		// 开始滑动
		for (int i = 0; i < charArray.length; i++) {

			Character character = charArray[i];
			Integer num = window.get(character);

			// 当前窗口中无该字符
			if (Objects.isNull(num)) {
				window.getOrDefault(character, window.getOrDefault(character, 0) + 1);
				maxLength ++;
				continue;
			}


		}


		return maxLength;
	}
}
