package record.leetcode.editor.cn;

//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//
//
// 示例 1：
//
//
//输入：nums = [3,2,3]
//输出：3
//
// 示例 2：
//
//
//输入：nums = [2,2,1,1,1,2,2]
//输出：2
//
//
//
//提示：
//
//
// n == nums.length
// 1 <= n <= 5 * 104
// -109 <= nums[i] <= 109
//
//
//
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
// Related Topics 数组 哈希表 分治 计数 排序
// 👍 1675 👎 0

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	public static void main(String[] args) {
		Solution solution = new MajorityElement().new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int majorityElement(int[] nums) {
			// 多数元素临界值
			int limit = nums.length / 2;

			// 每个数字出现的次数
			Map<Integer, Integer> frequencyForNum = new HashMap<>();
			for (int num : nums) {
				frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
			}

			// 返回多数元素
			for (Integer key : frequencyForNum.keySet()) {
				if (frequencyForNum.get(key) > limit) {
					return key;
				}
			}
			return -1;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
