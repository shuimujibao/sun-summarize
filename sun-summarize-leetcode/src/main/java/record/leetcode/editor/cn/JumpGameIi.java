package record.leetcode.editor.cn;
//给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
//
// 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
//
//
// 0 <= j <= nums[i]
// i + j < n
//
//
// 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
//
//
//
// 示例 1:
//
//
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
//
//
// 示例 2:
//
//
//输入: nums = [2,3,0,1,4]
//输出: 2
//
//
//
//
// 提示:
//
//
// 1 <= nums.length <= 10⁴
// 0 <= nums[i] <= 1000
// 题目保证可以到达 nums[n-1]
//
//
// Related Topics贪心 | 数组 | 动态规划
//
// 👍 2578, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

import java.util.Arrays;

public class JumpGameIi {
	public static void main(String[] args) {
		Solution solution = new JumpGameIi().new Solution();

		int[] arr = new int[]{3, 1, 4, 2, 6, 8, 2, 5};
		solution.jump2(arr);

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		/**
		 * 问题描述：
		 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。获取能走到最后一个节点的最小步数。
		 * <p>
		 * 1、当前位置索引：                                                       index = [0,1,2,3,4]
		 * 2、当前数组：                                                           nums = [2,3,1,1,4]
		 * 3、索引跳转：
		 * （1）只看当前位置最远可跳转到数组的位置索引：        farthest = index+ nums[index] = [2,4,3,4,8]
		 * （2）考虑前一个位置当前位置最远可跳转到数组的位置索引：Max(farthest[i-1],farthest[i])=[2,4,4,4,8]
		 * <p>
		 * index = 0 value = 2 可跳转至 index = 1;index = 2;
		 * index = 1 value = 3 可跳转至 index = 2;index = 3;index = 4;
		 * index = 2 value = 1 可跳转至 index = 3;
		 * index = 3 value = 1 可跳转至 index = 4;（抵达数组末尾）
		 * index = 4 value = 4 可跳转至 index = 5;index = 6;index = 7;index = 8;index = 9;
		 * <p>
		 * 可抵达末尾的路线(index)为
		 * 1-> 2 -> 3 -> 4 (一次走一步)
		 * 2-> 3 -> 4 (先走两步，走一步，再走一步)
		 * 1-> 4 (先走一步，再走三步)
		 * <p>
		 * 问题可转化为获取上述三种路线的最小值
		 *
		 * @param nums 数组
		 * @return boolean
		 */

		/**
		 * 备忘录
		 */
		private int[] memo;

		public int jump(int[] nums) {
			int n = nums.length;
			// 备忘录都初始化为 n，相当于 INT_MAX
			// 因为从 0 跳到 n - 1 最多 n - 1 步
			memo = new int[n];
			Arrays.fill(memo, n);
			return dp(nums, 0);
		}

		/**
		 * 定义：从索引 p 跳到最后一格，至少需要 dp(nums, p) 步
		 *
		 * @param nums 数组
		 * @param p    索引
		 * @return int
		 */
		int dp(int[] nums, int p) {
			// base case 就是当 p 超过最后一格时，不需要跳跃：
			int n = nums.length;

			// base case
			if (p >= n - 1) {
				return 0;
			}

			// 子问题已经计算过
			if (memo[p] != n) {
				return memo[p];
			}

			int steps = nums[p];

			// 你可以选择跳 1 步，2 步...
			for (int i = 1; i <= steps; i++) {
				// 穷举每一个选择
				// 计算每一个子问题的结果
				int subProblem = dp(nums, p + i);
				// 取其中最小的作为最终结果
				memo[p] = Math.min(memo[p], subProblem + 1);
			}

			return memo[p];
		}


		/**
		 * 局部最优全局最优
		 * <p>
		 * 索引：[0,1,2,3,4,5,6,7]
		 * 数组：[3,1,4,2,6,8,2,5]
		 * <p>
		 * 当index = 0 value = 3;可以向前跳1，2或3步
		 * <p>
		 * （1）向前跳一步，当index = 1 value = 1  index的覆盖范围为[1~2]
		 * （2）向前跳两步，当index = 2 value = 4  index的覆盖范围为[2~6]
		 * （3）向前跳三步，当index = 3 value = 2  index的覆盖范围为[3~5]
		 * <p>
		 * 根据贪心算法，局部最优全局最优，肯定选择跳两步为最优解答，因为其向后覆盖范围最广
		 *
		 * @param nums 数组
		 * @return int
		 */
		public int jump2(int[] nums) {
			int n = nums.length;

			int end = 0;
			int farthest = 0;
			int jumps = 0;

			for (int i = 0; i < n - 1; i++) {

				// 当前位置可向后覆盖的最远距离
				farthest = Math.max(nums[i] + i, farthest);

				// mums[i] 可跳转为位置 [i~end~farthest]
				// end的位置对应的下个跳转覆盖范围最大
				// 到了跳转可覆盖最大位置，进行下一步跳转 ，jumps++
				if (end == i) {
					jumps++;
					end = farthest;
				}
			}
			return jumps;
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}
