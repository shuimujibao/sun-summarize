package record.leetcode.editor.cn;
//给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
//
//
//
// 示例 1:
//
//
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右轮转 1 步: [7,1,2,3,4,5,6]
//向右轮转 2 步: [6,7,1,2,3,4,5]
//向右轮转 3 步: [5,6,7,1,2,3,4]
//
//
// 示例 2:
//
//
//输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
//解释:
//向右轮转 1 步: [99,-1,-100,3]
//向右轮转 2 步: [3,99,-1,-100]
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// -2³¹ <= nums[i] <= 2³¹ - 1
// 0 <= k <= 10⁵
//
//
//
//
// 进阶：
//
//
// 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
// 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
//
//
// Related Topics数组 | 数学 | 双指针
//
// 👍 2220, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

public class RotateArray {
	public static void main(String[] args) {
		Solution solution = new RotateArray().new Solution();

		int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
		int k = 3;

		solution.rotate(nums, k);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public void rotate(int[] nums, int k) {
			// 数组长度
			int length = nums.length;

			if (k == length) {
				return;
			}

			k = k % length;

			// 整个数据反转 0～n;
			reverse(nums, 0, length - 1);
			// 反转前半段   0～k;
			reverse(nums, 0, k - 1);
			// 反转后半段   k+1~n;
			reverse(nums, k, length - 1);
		}

		/**
		 * 部分反转数据
		 *
		 * @param nums  数组
		 * @param start 开始位置
		 * @param end   结束位置
		 */
		private void reverse(int[] nums, int start, int end) {
			while (start < end) {
				swap(nums, start++, end--);
			}
		}

		/**
		 * 交换数组两个位置
		 *
		 * @param nums   数组
		 * @param index1 位置1
		 * @param index2 位置1
		 */
		private void swap(int[] nums, int index1, int index2) {
			int temp = nums[index1];
			nums[index1] = nums[index2];
			nums[index2] = temp;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
