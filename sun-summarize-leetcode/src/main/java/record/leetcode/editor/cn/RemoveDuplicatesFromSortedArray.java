package record.leetcode.editor.cn;

//给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持
//一致 。然后返回 nums 中唯一元素的个数。
//
// 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
//
//
// 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不
//重要。
// 返回 k 。
//
//
// 判题标准:
//
// 系统会用下面的代码来测试你的题解:
//
//
//int[] nums = [...]; // 输入数组
//int[] expectedNums = [...]; // 长度正确的期望答案
//
//int k = removeDuplicates(nums); // 调用
//
//assert k == expectedNums.length;
//for (int i = 0; i < k; i++) {
//    assert nums[i] == expectedNums[i];
//}
//
// 如果所有断言都通过，那么您的题解将被 通过。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,2]
//输出：2, nums = [1,2,_]
//解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
//
//
// 示例 2：
//
//
//输入：nums = [0,0,1,1,1,2,2,3,3,4]
//输出：5, nums = [0,1,2,3,4]
//解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 10⁴
// -10⁴ <= nums[i] <= 10⁴
// nums 已按 非严格递增 排列
//
//
// Related Topics 数组 双指针 👍 3505 👎 0

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
		int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
		int k = solution.removeDuplicates(nums);
		System.out.println("nums : " + Arrays.toString(nums));
		System.out.println("k:" + k);
	}

	/**
	 * 初始值：0, 0, 1, 1, 1, 2, 2, 3, 3, 4           low = 0,i=0
	 * <p>
	 * 第一次：0, 1, 0, 1, 1, 2, 2, 3, 3, 4 （1-->0 ） low = 1,i=2
	 * <p>
	 * 第二次：0, 1, 2, 1, 1, 0, 2, 3, 3, 4 （2-->0 ） low = 2,i=5
	 * <p>
	 * 第三次：0, 1, 2, 3, 1, 0, 2, 1, 3, 4 （3-->1 ） low = 3,i=7
	 * <p>
	 * 第四次：0, 1, 2, 3, 4, 0, 2, 1, 3, 1 （4-->1 ） low = 4,i=8
	 */
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int removeDuplicates(int[] nums) {
			// 低位索引位置
			int low = 0;

			// 临时值
			int temp = Integer.MAX_VALUE;

			// 遍历数组
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == temp) {
					continue;
				}

				temp = nums[i];

				// 若低位与高位不同，则交换元素位置
				nums[low++] = nums[i];
			}
			return low;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
