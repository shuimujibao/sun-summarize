package record.leetcode.editor.cn;
//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
//
//
//
// 示例 1：
//
//
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
//
//
// 示例 2：
//
//
//输入：s = "a"
//输出：[["a"]]
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 16
// s 仅由小写英文字母组成
//
//
// Related Topics字符串 | 动态规划 | 回溯
//
// 👍 1823, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {
	public static void main(String[] args) {
		Solution solution = new PalindromePartitioning().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		List<List<String>> res = new ArrayList<>();
		LinkedList<String> path = new LinkedList<>();

		public List<List<String>> partition(String s) {
			dfs(s, 0);
			return res;
		}

		void dfs(String s, int start) {
			if (s.length() == start) {
				res.add(new ArrayList<>(path));
			}

			for (int i = start; i < s.length(); i++) {
				String curStr = s.substring(start, i + 1);
				if (!isHuiWen(curStr)) {
					continue;
				}
				path.add(curStr);
				dfs(s, i + 1);
				path.removeLast();
			}
		}

		Boolean isHuiWen(String curStr) {
			int low = 0;
			int high = curStr.length() - 1;

			while (low < high) {
				if (curStr.charAt(low) != curStr.charAt(high)) {
					return false;
				}
				low++;
				high--;
			}
			return true;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
