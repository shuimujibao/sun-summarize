package record.leetcode.editor.cn;
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：["()"]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 8
//
//
// Related Topics字符串 | 动态规划 | 回溯
//
// 👍 3649, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public static void main(String[] args) {
		Solution solution = new GenerateParentheses().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		/**
		 * 现在有 2n 个位置，每个位置可以放置字符 ( 或者 )，组成的所有括号组合中，有多少个是合法的？
		 * <p>
		 * 不过为了减少不必要的穷举，我们要知道合法括号串有以下性质：
		 * 1、一个「合法」括号组合的左括号数量一定等于右括号数量，这个很好理解。
		 * 2、对于一个「合法」的括号字符串组合 p，必然对于任何 0 <= i < len(p)
		 * 都有：子串 p[0..i] 中左括号的数量都大于或等于右括号的数量。
		 *
		 * @param n  n对括号
		 * @return 结果
		 */
		// 记录所有合法的括号组合
		List<String> res = new ArrayList<>();
		// 回溯过程中的路径
		StringBuilder track = new StringBuilder();

		public List<String> generateParenthesis(int n) {
			if (n == 0) {
				return new ArrayList<>();
			}
			// 可用的左括号和右括号数量初始化为 n
			backtrack(n, n);
			return res;
		}

		// 可用的左括号数量为 left 个，可用的右括号数量为 right 个
		void backtrack(int left, int right) {
			// 若左括号剩下的多，说明不合法
			if (right < left) return;
			// 数量小于 0 肯定是不合法的
			if (left < 0) return;
			// 当所有括号都恰好用完时，得到一个合法的括号组合
			if (left == 0 && right == 0) {
				res.add(track.toString());
				return;
			}

			// 尝试放一个左括号
			track.append('('); // 选择
			backtrack(left - 1, right);
			track.deleteCharAt(track.length() - 1); // 撤消选择

			// 尝试放一个右括号
			track.append(')'); // 选择
			backtrack(left, right - 1);
			track.deleteCharAt(track.length() - 1); // 撤消选择
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
