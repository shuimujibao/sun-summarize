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
import java.util.stream.Collectors;

public class GroupAnagrams {
	public static void main(String[] args) {
		Solution solution = new GroupAnagrams().new Solution();
		String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		solution.groupAnagrams(strs);
		solution.groupAnagrams(strs);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<List<String>> groupAnagrams(String[] strs) {
			// 编码到分组的映射
			HashMap<String, List<String>> codeToGroup = new HashMap<>();
			for (String s : strs) {
				// 对字符串进行编码
				String code = encode(s);
				// 把编码相同的字符串放在一起
				codeToGroup.putIfAbsent(code, new LinkedList<>());
				codeToGroup.get(code).add(s);
			}
			// 获取结果
			return new LinkedList<>(codeToGroup.values());
		}

		// 利用每个字符的出现次数进行编码
		String encode(String s) {
			char[] count = new char[26];
			for (char c : s.toCharArray()) {
				int delta = c - 'a';
				count[delta]++;
			}
			return new String(count);
		}

		public List<List<String>> groupAnagrams2(String[] strs) {
			// 遍历字符数组同时专为 List
			Collection<List<String>> values = Arrays.stream(strs).collect(
				// 对当前字符数组进行分组
				Collectors.groupingBy(s ->
					//
					s.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString()
				)
			).values();

			// 返回分组后的结果
			return new ArrayList<>(values);

		}


		public List<List<String>> groupAnagrams3(String[] strs) {
			// key = 字符串中asscii升序后对应的字符串
			// value = 当前字符串的集合，即异位词的集合
			Map<String, List<String>> map = new HashMap<>();
			for (String s : strs) {
				// 获取当前字符串，对应的字符码
				char[] chars = s.toCharArray();
				// 排序，每个异位词排序结果相同，则对应的升序字符串相同
				Arrays.sort(chars);
				String sorted = new String(chars);

				// 集合中不包含先初始化空集合，再插入
				// 若包含则直接插入
				if (!map.containsKey(sorted)) {
					map.put(sorted, new ArrayList<>());
				}

				map.get(sorted).add(s);
			}
			return new ArrayList<>(map.values());
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
