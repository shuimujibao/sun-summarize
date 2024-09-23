package record.leetcode.editor.cn;
//给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
// 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁴
// 0 <= nums[i] <= 10⁵
//
//
// Related Topics贪心 | 数组 | 动态规划
//
// 👍 2838, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

public class JumpGame {
	public static void main(String[] args) {
		Solution solution = new JumpGame().new Solution();
		int[] arr = new int[]{3, 2, 1, 0, 4};
		solution.canJump(arr);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		/**
		 * 问题描述：
		 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。判断你是否能够到达最后一个下标。
		 * <p>
		 * 1、当前位置索引：                                                       index = [0,1,2,3,4]
		 * 2、当前数组：                                                           nums = [2,3,1,1,4]
		 * 3、索引跳转：
		 * （1）只看当前位置最远可跳转到数组的位置索引：        farthest = index+ nums[index] = [2,4,3,4,8]
		 * （2）考虑前一个位置当前位置最远可跳转到数组的位置索引：Max(farthest[i-1],farthest[i])=[2,4,4,4,8]
		 * === 为啥找最大？ 可以理解成覆盖的范围
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
		 * 即当前问题可转化为求哪种跳转方案，跳转的距离最远，如果当前最远距离不小于数组长度即可到达最后一个位置
		 *
		 * @param nums 数组
		 * @return boolean
		 */
		public boolean canJump(int[] nums) {
			int farthest = 0;
			int n = nums.length;
			// 遍历到倒数第二个节点即可
			for (int i = 0; i < n - 1; i++) {

				farthest = Math.max(farthest, i + nums[i]);

				// 因为遍历终结点为 n - 1，最远只能到当前位置，遍历结束
				if (farthest == i) {
					return false;
				}
			}
			return farthest >= n - 1;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
