package record.leetcode.editor.cn;
//给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
//
//
//
// 示例 1：
//
//
//输入：nums = [10,5,2,6], k = 100
//输出：8
//解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3], k = 0
//输出：0
//
//
//
// 提示:
//
//
// 1 <= nums.length <= 3 * 10⁴
// 1 <= nums[i] <= 1000
// 0 <= k <= 10⁶
//
//
// Related Topics数组 | 滑动窗口
//
// 👍 788, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

public class SubarrayProductLessThanK {
	public static void main(String[] args) {
		Solution solution = new SubarrayProductLessThanK().new Solution();

		int[] nums = new int[]{10,5,2,6};

		solution.numSubarrayProductLessThanK(nums, 100);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		/**
		 * nums 全是正数，故选择滑动窗口
		 *
		 * @param nums 数组
		 * @param k    阈值
		 */
		public int numSubarrayProductLessThanK(int[] nums, int k) {
			// 窗口左右边界
			int left = 0;
			int right = 0;

			// 当前窗口内的积
			int windowProduct = 1;

			// 符合要求的连续子数组数量
			int count = 0;

			while (right < nums.length) {
				// 扩大窗口，并更新窗口数据
				windowProduct = windowProduct * nums[right];
				right++;

				while (left < right && windowProduct >= k) {
					// 缩小窗口，并更新窗口数据
					windowProduct = windowProduct / nums[left];
					left++;
				}
				// 现在必然是一个合法的窗口，但注意思考这个窗口中的子数组个数怎么计算：
				// 比方说 left = 1, right = 4 划定了 [1, 2, 3] 这个窗口（right 是开区间）
				// 但不止 [left..right] 是合法的子数组，[left+1..right], [left+2..right] 等都是合法子数组
				// 所以我们需要把 [3], [2,3], [1,2,3] 这 right - left 个子数组都加上
				count += right - left;
			}

			return count;
		}

		/**
		 * 超过int类型最大值，不能用
		 */
		public int numSubarrayProductLessThanKTest(int[] nums, int k) {
			// 前缀积
			int[] preProduct = new int[nums.length];

			preProduct[0] = nums[0];

			for (int i = 1; i < nums.length; i++) {
				preProduct[i] = preProduct[i - 1] * nums[i];
			}

			int res = 0;

			for (int i = 0; i < nums.length; i++) {

				if (nums[i] < k) {
					res++;
				}

				for (int j = i + 1; j < nums.length; j++) {

					int curProduct = preProduct[j] / preProduct[i] * nums[i];

					if (curProduct < k) {
						res++;
					}
				}

			}
			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
