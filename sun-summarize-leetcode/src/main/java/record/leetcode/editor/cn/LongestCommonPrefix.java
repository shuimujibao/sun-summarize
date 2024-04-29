package record.leetcode.editor.cn;

//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//
// 示例 2：
//
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
//
// Related Topics 字典树 字符串 👍 3089 👎 0

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.LinkedBlockingQueue;

public class LongestCommonPrefix {
	public static void main(String[] args) throws InterruptedException {
		Solution solution = new LongestCommonPrefix().new Solution();
		String[] strs = new String[]{"flower", "flow", "flight"};
		String s = solution.longestCommonPrefix(strs);
		System.out.println(s);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public String longestCommonPrefix(String[] strs) throws InterruptedException {
			// 队列
			LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();

			// 两两比较
			for (String str : strs) {
				// 出队
				String queueValue = queue.poll();

				// 入队
				if (StringUtils.isBlank(queueValue)) {
					queue.put(str);
					continue;
				}

				// 获取当前队列中字符串与当前字符串公共前缀,并入队
				queue.put(getCommonPrefix(queueValue, str));
			}

			return queue.poll();
		}

		/**
		 * 两字符串最长公共前缀
		 *
		 * @param s1 字符串一
		 * @param s2 字符串二
		 * @return String
		 */
		private String getCommonPrefix(String s1, String s2) {
			int index = 0;

			while (index < s2.length() && index < s1.length()) {
				if (s1.charAt(index) == s2.charAt(index)) {
					index++;
				} else {
					break;
				}
			}

			return s1.substring(0, index);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
