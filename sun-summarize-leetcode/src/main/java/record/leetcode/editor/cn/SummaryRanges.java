package record.leetcode.editor.cn;
//给定一个 无重复元素 的 有序 整数数组 nums 。
//
// 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于
//nums 的数字 x 。
//
// 列表中的每个区间范围 [a,b] 应该按如下格式输出：
//
//
// "a->b" ，如果 a != b
// "a" ，如果 a == b
//
//
//
//
// 示例 1：
//
//
//输入：nums = [0,1,2,4,5,7]
//输出：["0->2","4->5","7"]
//解释：区间范围是：
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
//
//
// 示例 2：
//
//
//输入：nums = [0,2,3,4,6,8,9]
//输出：["0","2->4","6","8->9"]
//解释：区间范围是：
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 20
// -2³¹ <= nums[i] <= 2³¹ - 1
// nums 中的所有值都 互不相同
// nums 按升序排列
//
//
// Related Topics数组
//
// 👍 405, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	public static void main(String[] args) {
		Solution solution = new SummaryRanges().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<String> summaryRanges(int[] nums) {
			// 初始化结果列表
			List<String> result = new ArrayList<>();

			if (nums == null || nums.length == 0) {
				return result;
			}

			int n = nums.length;
			int start = nums[0]; // 起始位置

			for (int i = 0; i < n; i++) {
				// 如果到达最后一个元素或者下一个元素不连续，则记录当前范围
				if (i == n - 1 || nums[i] + 1 != nums[i + 1]) {
					// 如果起始位置和当前位置相同，则只加入单个数字
					if (start == nums[i]) {
						result.add(String.valueOf(start));
					} else {
						result.add(start + "->" + nums[i]);
					}
					// 更新起始位置为下一个数字
					if (i < n - 1) {
						start = nums[i + 1];
					}
				}
			}

			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
