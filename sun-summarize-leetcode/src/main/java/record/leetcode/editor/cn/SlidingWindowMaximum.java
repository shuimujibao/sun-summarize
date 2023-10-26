package record.leetcode.editor.cn;

//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。
//
// 返回 滑动窗口中的最大值 。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
// 示例 2：
//
//
//输入：nums = [1], k = 1
//输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// 1 <= k <= nums.length
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列）
// 👍 2573 👎 0

import java.util.PriorityQueue;

public class SlidingWindowMaximum {
	public static void main(String[] args) {
		Solution solution = new SlidingWindowMaximum().new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int[] maxSlidingWindow(int[] nums, int k) {
			int n = nums.length;
			PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) ->
				pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]);

			for (int i = 0; i < k; ++i) {
				pq.offer(new int[]{nums[i], i});
			}

			int[] ans = new int[n - k + 1];
			ans[0] = pq.peek()[0];

			for (int i = k; i < n; ++i) {
				pq.offer(new int[]{nums[i], i});
				while (pq.peek()[1] <= i - k) {
					pq.poll();
				}
				ans[i - k + 1] = pq.peek()[0];
			}

			return ans;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
