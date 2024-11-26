package record.leetcode.editor.cn;
//给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
//
// 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
//
// 请找到和最小的 k 个数对 (u1,v1), (u2,v2) ... (uk,vk) 。
//
//
//
// 示例 1:
//
//
//输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//输出: [1,2],[1,4],[1,6]
//解释: 返回序列中的前 3 对数：
//     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
//
//
// 示例 2:
//
//
//输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//输出: [1,1],[1,1]
//解释: 返回序列中的前 2 对数：
//     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
//
//
//
//
// 提示:
//
//
// 1 <= nums1.length, nums2.length <= 10⁵
// -10⁹ <= nums1[i], nums2[i] <= 10⁹
// nums1 和 nums2 均为 升序排列
//
// 1 <= k <= 10⁴
// k <= nums1.length * nums2.length
//
//
// Related Topics数组 | 堆（优先队列）
//
// 👍 630, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

import java.util.*;

public class FindKPairsWithSmallestSums {
	public static void main(String[] args) {
		Solution solution = new FindKPairsWithSmallestSums().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
			// 小顶堆，比较逻辑是两个列表的和
			PriorityQueue<List<Integer>> queue = new PriorityQueue<>(
				Comparator.comparingInt(o -> (o.get(0) + o.get(1)))
			);
			for (int u : nums1) {
				for (int v : nums2) {
					List<Integer> tempList = Arrays.asList(u, v);
					if (queue.size() < k) {
						queue.add(tempList);
					} else {
						List<Integer> list = queue.peek();
						if(list == null){
							continue;
						}
						int peekSum = list.get(0) + list.get(1);
						int currSum = u + v;
						if (peekSum > currSum) {
							queue.poll();
							queue.add(tempList);
						}
					}
				}
			}
			List<List<Integer>> res = new ArrayList<>();
			while (!queue.isEmpty()) {
				res.add(queue.poll());
			}
			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
