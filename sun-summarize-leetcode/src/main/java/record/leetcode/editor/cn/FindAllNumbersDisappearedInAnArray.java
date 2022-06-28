package record.leetcode.editor.cn;

//给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数
//字，并以数组的形式返回结果。
//
//
//
// 示例 1：
//
//
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[5,6]
//
//
// 示例 2：
//
//
//输入：nums = [1,1]
//输出：[2]
//
//
//
//
// 提示：
//
//
// n == nums.length
// 1 <= n <= 105
// 1 <= nums[i] <= n
//
//
// 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
// Related Topics 数组 哈希表
// 👍 1015 👎 0

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray{
    public static void main(String[] args) {
        Solution solution = new FindAllNumbersDisappearedInAnArray().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
		// 遍历原数组，将相应位置的元素对应的索引位置的值标记为负数
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]);
			nums[index - 1] = Math.abs(nums[index - 1]) * -1;
		}
		// 最后，再遍历一次数组，把非负数挑出来即为在 [1, n] 范围内但没有出现在 nums 中的数字
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				result.add(i + 1);
			}
		}
		return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
