package record.leetcode.editor.cn;
//给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
//
// 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且 至少 有 h 篇论文被引用次
//数大于等于 h 。如果 h 有多种可能的值，h 指数 是其中最大的那个。
//
//
//
// 示例 1：
//
//
//输入：citations = [3,0,6,1,5]
//输出：3
//解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
//     由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
//
// 示例 2：
//
//
//输入：citations = [1,3,1]
//输出：1
//
//
//
//
// 提示：
//
//
// n == citations.length
// 1 <= n <= 5000
// 0 <= citations[i] <= 1000
//
//
// Related Topics数组 | 计数排序 | 排序
//
// 👍 535, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

import java.util.Arrays;

public class HIndex {
	public static void main(String[] args) {
		Solution solution = new HIndex().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		/**
		 * 思路：
		 * <p>
		 * 示例一
		 * 输入：citations = [3,0,6,1,5]
		 * 输出：3
		 * <p>
		 * 示例二
		 * 输入：citations = [1,3,1]
		 * 输出：1
		 * ======================================================
		 * 解题步骤：
		 * 1. 先对citations进行升续排列 [0,1,3,5,6]
		 * 2. 从后往前遍历，如果当前值大于等于下标，则返回当前下标
		 * 3. 如果遍历完都没有找到，说明没有满足条件的，直接return 0
		 * <p>
		 * 时间复杂度：O(nlogn)
		 * 空间复杂度：O(1)
		 * <p>
		 *
		 * @param citations 论文引用此次
		 * @return 输入：citations = [3,0,6,1,5]
		 */
		public int hIndex(int[] citations) {
			Arrays.sort(citations);
			int n = citations.length;
			for (int i = 0; i < n; i++) {
				if (citations[i] >= n - i) {
					return n - i;
				}
			}
			return 0;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
