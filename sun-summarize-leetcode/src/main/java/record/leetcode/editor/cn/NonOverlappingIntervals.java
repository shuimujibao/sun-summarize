package record.leetcode.editor.cn;

//给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重
//叠 。
//
//
//
// 示例 1:
//
//
//输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
//输出: 1
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
//
//
// 示例 2:
//
//
//输入: intervals = [ [1,2], [1,2], [1,2] ]
//输出: 2
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
//
//
// 示例 3:
//
//
//输入: intervals = [ [1,2], [2,3] ]
//输出: 0
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
//
//
//
//
// 提示:
//
//
// 1 <= intervals.length <= 105
// intervals[i].length == 2
// -5 * 104 <= starti < endi <= 5 * 104
//
// Related Topics 贪心 数组 动态规划 排序
// 👍 687 👎 0

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
	public static void main(String[] args) {
		Solution solution = new NonOverlappingIntervals().new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int eraseOverlapIntervals(int[][] intervals) {
			if (intervals.length == 0) {
				return 0;
			}

			Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

			int cnt = 1;
			int end = intervals[0][1];

			for (int[] interval : intervals) {
				if (interval[0] < end) {
					continue;
				}
				end = interval[1];
				cnt++;
			}
			return intervals.length - cnt;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
