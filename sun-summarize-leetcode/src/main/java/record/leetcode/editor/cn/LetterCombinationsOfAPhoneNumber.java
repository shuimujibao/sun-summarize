package record.leetcode.editor.cn;
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//
//
// 示例 1：
//
//
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//
//
// 示例 2：
//
//
//输入：digits = ""
//输出：[]
//
//
// 示例 3：
//
//
//输入：digits = "2"
//输出：["a","b","c"]
//
//
//
//
// 提示：
//
//
// 0 <= digits.length <= 4
// digits[i] 是范围 ['2', '9'] 的一个数字。
//
//
// Related Topics哈希表 | 字符串 | 回溯
//
// 👍 2877, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LetterCombinationsOfAPhoneNumber {
	public static void main(String[] args) {
		Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
		String digits = "423";

		solution.letterCombinations(digits);

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		/**
		 * 输入digits 2~9
		 * <p>
		 * 示例 1：
		 * 输入：digits = "23"
		 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
		 * 示例 2：
		 * 输入：digits = ""
		 * 输出：[]
		 * 示例 3：
		 * 输入：digits = "2"
		 * 输出：["a","b","c"]
		 * <p>
		 * =====================================================分析====================================================
		 *
		 * @param digits 数字串
		 * @return 拼接的可能子序列
		 */
		/**
		 * 每个数字到字母的映射
		 */
		private String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

		/**
		 * 所有子序列集合
		 */
		private List<String> res = new ArrayList<>();

		public List<String> letterCombinations(String digits) {

			if (Objects.isNull(digits)) {
				return res;
			}

			char[] charArray = digits.toCharArray();


//			backTrace(int[] digits)
			return null;
		}

		private void backTrace(int[] digits) {

		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
