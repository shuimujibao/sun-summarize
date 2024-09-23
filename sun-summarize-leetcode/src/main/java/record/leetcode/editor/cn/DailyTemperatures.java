package record.leetcode.editor.cn;
//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现
//在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
//
//
//
// 示例 1:
//
//
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
//
//
// 示例 2:
//
//
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
//
//
// 示例 3:
//
//
//输入: temperatures = [30,60,90]
//输出: [1,1,0]
//
//
//
// 提示：
//
//
// 1 <= temperatures.length <= 10⁵
// 30 <= temperatures[i] <= 100
//
//
// Related Topics栈 | 数组 | 单调栈
//
// 👍 1809, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
	public static void main(String[] args) {
		Solution solution = new DailyTemperatures().new Solution();

		int[] arr = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
		int[] ints = solution.dailyTemperatures(arr);
		System.out.println(Arrays.toString(ints));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int[] dailyTemperatures(int[] temperatures) {
			// 结果集
			int[] answer = new int[temperatures.length];
			for (int i = 0; i < temperatures.length; i++) {

				// 当前单调栈
				MaxStack maxStack = new MaxStack();

				// 从i之后遍历入栈
				// 直至单调栈中的最大值大于初始值
				for (int j = i; j < temperatures.length && maxStack.max() <= temperatures[i]; j++) {
					maxStack.add(temperatures[j]);
				}
				answer[i] = maxStack.max().equals(temperatures[i]) ? 0 : maxStack.length() - 1;
			}

			return answer;
		}

		class MaxStack {
			Stack<Integer> maxStk = new Stack<>();

			MaxStack() {
			}

			public Integer max() {
				if (maxStk.isEmpty()) {
					return 0;
				}
				return maxStk.peek();
			}

			public void add(Integer n) {
				if (maxStk.isEmpty() || n > maxStk.peek()) {
					maxStk.add(n);
				} else {
					maxStk.add(maxStk.peek());
				}
			}

			public int length() {
				return maxStk.size();
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
