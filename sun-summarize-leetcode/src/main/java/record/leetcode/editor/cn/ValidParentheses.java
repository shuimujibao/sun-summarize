package record.leetcode.editor.cn;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
// 每个右括号都有一个对应的相同类型的左括号。
//
//
//
//
// 示例 1：
//
//
//输入：s = "()"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "()[]{}"
//输出：true
//
//
// 示例 3：
//
//
//输入：s = "(]"
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串
// 👍 4321 👎 0

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
	public static void main(String[] args) {
		Solution solution = new ValidParentheses().new Solution();
		solution.isValid("([(]))");

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		public boolean isValid(String s) {
			HashMap<String, String> rule = new HashMap<>();
			rule.put("(", ")");
			rule.put("{", "}");
			rule.put("[", "]");

			Stack<String> stack = new Stack<>();

			int index = 0;
			int length = s.length();
			while (index < length) {

				String currentValue = String.valueOf(s.charAt(index));

				index++;

				if (!stack.isEmpty() && currentValue.equals(rule.get(stack.peek()))) {
					stack.pop();

					continue;
				}

				stack.push(currentValue);
			}

			return stack.isEmpty();
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
