package record.leetcode.editor.cn;

//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
//
//
//
// 示例 1:
//
//
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
// 示例 2:
//
//
//输入: strs = [""]
//输出: [[""]]
//
//
// 示例 3:
//
//
//输入: strs = ["a"]
//输出: [["a"]]
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 10⁴
// 0 <= strs[i].length <= 100
// strs[i] 仅包含小写字母
//
//
// Related Topics 数组 哈希表 字符串 排序 👍 1931 👎 0

import java.util.*;

public class GroupAnagrams {
	public static void main(String[] args) {
		Solution solution = new GroupAnagrams().new Solution();
//		String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		String[] strs = new String[]{"ddddddddddg", "dgggggggggg"};
		solution.groupAnagrams(strs);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<List<String>> groupAnagrams(String[] strs) {

			// 返回值集合
			HashMap<String, List<String>> resultMap = new HashMap<>();

			for (String s : strs) {

				// 统计每个字符串中字符出现的次数
				HashMap<Character, Integer> recordMap = new HashMap<>();
				char[] charArray = s.toCharArray();
				Arrays.sort(charArray);

				for (char c : charArray) {
					recordMap.put(c, recordMap.getOrDefault(c, 1));
				}

				// 构造结果集中的key
				// eg: a1b3c1
				StringBuilder resultMapKey = new StringBuilder();
				recordMap.forEach((key, value) -> resultMapKey.append(key).append(value));

				List<String> resultMapValue = resultMap.get(resultMapKey.toString());
				if (Objects.isNull(resultMapValue)) {
					resultMapValue = new ArrayList<>();
				}
				resultMapValue.add(s);

				// 记录结果
				resultMap.put(resultMapKey.toString(), resultMapValue);
			}

			return new ArrayList<>(resultMap.values());

//			return new ArrayList<>(Arrays.stream(strs)
//				.collect(Collectors.groupingBy(s ->
//					s.chars().sorted()
//						.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString())).values());
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
