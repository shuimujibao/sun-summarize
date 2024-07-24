package record.leetcode.editor.cn;

//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
//
// 换句话说，s1 的排列之一是 s2 的 子串 。
//
//
//
// 示例 1：
//
//
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
//
//
// 示例 2：
//
//
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= s1.length, s2.length <= 104
// s1 和 s2 仅包含小写字母
//
// Related Topics 哈希表 双指针 字符串 滑动窗口
// 👍 671 👎 0

import java.util.HashMap;
import java.util.Map;

public class PermutationInString{
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {

	public boolean checkInclusion(String t, String s) {
		Map<Character, Integer> need = new HashMap<>();
		Map<Character, Integer> window = new HashMap<>();
		for (char c : t.toCharArray()) {
			need.put(c, need.getOrDefault(c, 0) + 1);
		}

		int left = 0, right = 0;
		int valid = 0;
		while (right < s.length()) {
			char c = s.charAt(right);
			right++;
			// 进行窗口内数据的一系列更新
			if (need.containsKey(c)) {
				window.put(c, window.getOrDefault(c, 0) + 1);
				if (window.get(c).equals(need.get(c)))
					valid++;
			}

			// 判断左侧窗口是否要收缩
			while (right - left >= t.length()) {
				// 在这里判断是否找到了合法的子串
				if (valid == need.size())
					return true;
				char d = s.charAt(left);
				left++;
				// 进行窗口内数据的一系列更新
				if (need.containsKey(d)) {
					if (window.get(d).equals(need.get(d)))
						valid--;
					window.put(d, window.get(d) - 1);
				}
			}
		}
		// 未找到符合条件的子串
		return false;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
