package record.leetcode.editor.cn;

//给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
//
// 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
//
//
//
// 示例 1:
//
//
//输入: s = "tree"
//输出: "eert"
//解释: 'e'出现两次，'r'和't'都只出现一次。
//因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
//
//
// 示例 2:
//
//
//输入: s = "cccaaa"
//输出: "cccaaa"
//解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//注意"cacaca"是不正确的，因为相同的字母必须放在一起。
//
//
// 示例 3:
//
//
//输入: s = "Aabb"
//输出: "bbAa"
//解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
//注意'A'和'a'被认为是两种不同的字符。
//
//
//
//
// 提示:
//
//
// 1 <= s.length <= 5 * 105
// s 由大小写英文字母和数字组成
//
// Related Topics 哈希表 字符串 桶排序 计数 排序 堆（优先队列）
// 👍 420 👎 0

import java.util.*;

public class SortCharactersByFrequency{
    public static void main(String[] args) {
        Solution solution = new SortCharactersByFrequency().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String frequencySort(String s) {
		if (s.isEmpty() || s.length() == 1) {
			return s;
		}

		// 构造 HashMap。Key：s 中的每个元素；Value：对应元素出现的次数（即频率）
		Map<Character, Integer> store = new HashMap<>();

		for (char c : s.toCharArray()) {
			// 填充 HashMap。如果当前 Key c 不存在，getOrDefault() 方法返回默认值 0；
			// 否则返回当前 Key c 对应的 Value。
			// 不管哪种情况最后都在 0 或者 Value 的基础上 +1。
			store.put(c, store.getOrDefault(c, 0) + 1);
		}

		// 构造一个桶的集合（即一系列桶），桶的个数为 s 的长度 +1，因为 buckets[0] 没有意义
		// 目的是将出现频率为 i 的字符放到第 i 个桶里（即 buckets[i]）
		List<Character>[] buckets = new List[s.length() + 1];

		for (char key : store.keySet()) {
			// 某个字符在 HashMap 中的 Value 是几就会被放到第几个桶里
			int value = store.get(key);

			if (buckets[value] == null) {
				// 如果某个桶还未放入过字符（即未初始化），则初始化其为一个数组
				buckets[value] = new ArrayList<Character>();
			}

			buckets[value].add(key); // 然后将字符放到桶中
		}

		StringBuilder res = new StringBuilder();

		for (int i = buckets.length - 1; i > 0; --i) {
			// 遍历每个桶
			if (buckets[i] != null) {
				// 如果桶里有字符
				for (char j : buckets[i]) {
					// 遍历桶里的每个字符
					for (int k = i; k > 0; --k) {
						// 字符出现了几次就向 res 中添加几次该字符
						res.append(j);
					}
				}
			}
		}

		return res.toString();
    }


	public String frequencySort2(String s) {
		char[] chars = s.toCharArray();
		// s 中的字符 -> 该字符出现的频率
		HashMap<Character, Integer> charToFreq = new HashMap<>();
		for (char ch : chars) {
			charToFreq.put(ch, charToFreq.getOrDefault(ch, 0) + 1);
		}

		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((entry1, entry2) -> {
			// 队列按照键值对中的值（字符出现频率）从大到小排序
			return entry2.getValue().compareTo(entry1.getValue());
		});

		// 获取所有建值对
		Set<Map.Entry<Character, Integer>> entries = charToFreq.entrySet();

		charToFreq.keySet();
		charToFreq.values();

		entries.iterator().next();

		// 按照字符频率排序
		for (Map.Entry<Character, Integer> entry : charToFreq.entrySet()) {
			pq.offer(entry);
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			// 把频率最高的字符排在前面
			Map.Entry<Character, Integer> entry = pq.poll();

			// JDK 11
//			String part = String.valueOf(entry.getKey()).repeat(entry.getValue());
			sb.append("part");
		}

		return sb.toString();
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
