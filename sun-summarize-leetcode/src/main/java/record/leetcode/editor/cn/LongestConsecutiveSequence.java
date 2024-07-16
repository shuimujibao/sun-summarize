package record.leetcode.editor.cn;
//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
//
//
//
// 示例 1：
//
//
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
//
// 示例 2：
//
//
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
//
//
// Related Topics并查集 | 数组 | 哈希表
//
// 👍 2134, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

import java.util.HashSet;

public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		Solution solution = new LongestConsecutiveSequence().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int longestConsecutive(int[] nums) {
			// 哈希表记录数组，用于数字查找
			HashSet<Object> set = new HashSet<>();

			for (int num : nums) {
				set.add(num);
			}

			int res = 0;
			for (int num : nums) {
				if (set.contains(num - 1)) {
					// num不是连续子序列的第一个值
					continue;
				}
				// num是连续子序列的第一个值，开始向上计算连续子序列的最大长度
				int curNum = num;
				int curLen = 1;

				while (set.contains(curNum + 1)) {
					curNum += 1;
					curLen += 1;
				}

				// 更新最长连续序列长度
				res = Math.max(res, curLen);

			}

			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
