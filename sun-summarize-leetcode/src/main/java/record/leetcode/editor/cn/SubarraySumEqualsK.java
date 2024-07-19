package record.leetcode.editor.cn;
//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
//
// 子数组是数组中元素的连续非空序列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,1], k = 2
//输出：2
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3], k = 3
//输出：2
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 2 * 10⁴
// -1000 <= nums[i] <= 1000
// -10⁷ <= k <= 10⁷
//
//
// Related Topics数组 | 哈希表 | 前缀和
//
// 👍 2405, 👎 0
//
//
//
//

import java.util.HashMap;

public class SubarraySumEqualsK {
	public static void main(String[] args) {
		Solution solution = new SubarraySumEqualsK().new Solution();
		int[] nums = new int[]{1, 2, 1, 2, 1};
		int k = 3;
		solution.subarraySum2(nums, k);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int subarraySum(int[] nums, int k) {
			// 前缀和
			int[] preSum = new int[nums.length];
			preSum[0] = nums[0];
			for (int i = 1; i < nums.length; i++) {
				preSum[i] = nums[i] + preSum[i - 1];
			}

			// 子数组和为k的个数
			int res = 0;

			// 遍历获取和为k的子数组
			for (int i = 0; i < nums.length; i++) {
				// 子数组只有一个值
				if (nums[i] == k) {
					res++;
				}

				// 子数组有多个值
				for (int j = i + 1; j < nums.length; j++) {
					int sum = preSum[j] - preSum[i] + nums[i];
					if (sum == k) {
						res++;
					}
				}
			}
			return res;
		}


		public int subarraySum2(int[] nums, int k) {
			int n = nums.length;
			// 前缀和数组
			int[] preSum = new int[n + 1];
			preSum[0] = 0;
			// 前缀和到该前缀和出现次数的映射，方便快速查找所需的前缀和
			HashMap<Integer, Integer> count = new HashMap<>();
			count.put(0, 1);
			// 记录和为 k 的子数组个数
			int res = 0;

			// 计算 nums 的前缀和
			for (int i = 1; i <= n; i++) {
				preSum[i] = preSum[i - 1] + nums[i - 1];
				// 如果之前存在值为 need 的前缀和
				// 说明存在以 nums[i-1] 结尾的子数组的和为 k
				int need = preSum[i] - k;
				if (count.containsKey(need)) {
					res += count.get(need);
				}
				// 将当前前缀和存入哈希表
				if (!count.containsKey(preSum[i])) {
					count.put(preSum[i], 1);
				} else {
					count.put(preSum[i], count.get(preSum[i]) + 1);
				}
			}
			return res;
		}

		/**
		 * <p>
		 * map逻辑:
		 * 期望值:k
		 * preSum[i] = x;
		 * preSum[j] = y;
		 * 此时遍历到j
		 * <p>
		 * 工式：y - k = x
		 * 此时和为k的nums索引位置为 （i~j】左开右闭
		 * ================================================================================
		 * ========================== 示例！！！=============================================
		 * ================================================================================
		 * 期望值：k = 8
		 * <p>
		 * 索   引 = 0->1->2->3 -> 4
		 * nums[] = 1->6->2->5 -> 1
		 * preSum = 1->7->9->14->15
		 * <p>
		 * 此时遍历 preSum -> j =2
		 * preSum[j] - k = 9-8 =1
		 * 在 map中找 key =1 的值
		 * preSum[i] = 1 此时 j = 0
		 * <p>
		 * sum中 i+1 ~ j 的数据和为 k
		 *
		 * @param nums 数组
		 * @param k    期望值
		 * @return int
		 */
		public int subarraySum3(int[] nums, int k) {
			// 前缀和
			int[] preSum = new int[nums.length];
			preSum[0] = nums[0];
			for (int i = 1; i < nums.length; i++) {
				preSum[i] = nums[i] + preSum[i - 1];
			}

			// 子数组和为k的个数
			int res = 0;

			// 统计
			HashMap<Integer, Integer> count = new HashMap<>();

			// 遍历获取和为k的子数组
			for (int i = 0; i < preSum.length; i++) {

				int need = k - preSum[i];

				if (count.containsKey(need)) {
					res++;
				} else {
					count.put(preSum[i], count.get(preSum[i]) + 1);
				}

			}
			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
