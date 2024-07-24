package record.leetcode.editor.cn;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
//
//
//
// 示例 1:
//
//
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
//
// 示例 2:
//
//
//输入: nums = [0]
//输出: [0]
//
//
//
// 提示:
//
//
//
// 1 <= nums.length <= 104
// -231 <= nums[i] <= 231 - 1
//
//
//
//
// 进阶：你能尽量减少完成的操作次数吗？
// Related Topics 数组 双指针
// 👍 1854 👎 0

public class MoveZeroes{
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	/**
	 * 普通遍历->俩俩交换
	 * 第一轮：0,1,0,3,12
	 * 第一轮：1,0,0,3,12
	 * 第一轮：1,0,0,3,12
	 * 第一轮：1,0,3,0,12
	 * 第一轮：1,0,3,12,0
	 * <p>
	 * 第二轮：1,0,3,12,0
	 * 第二轮：1,3,0,12,0
	 * 第二轮：1,3,12,0,0
	 * <p>
	 * 双指针遍历->遇到0不动
	 * 第一轮：0,1,0,3,12
	 * 第一轮：1,0,0,3,12
	 * 第一轮：1,3,0,0,12
	 * 第一轮：1,3,12,0,0
	 *
	 * @param nums 数组
	 */
	public void moveZeroes(int[] nums) {
		int left = 0;
		int right = 0;

		while (right < nums.length) {
			if (nums[right] != 0) {
				swap(nums, left, right);
				left++;
			}
			right++;
		}
    }

	private void swap(int[] nums, int pos1, int pos2) {
		int temp = nums[pos1];
		nums[pos1] = nums[pos2];
		nums[pos2] = temp;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
}
