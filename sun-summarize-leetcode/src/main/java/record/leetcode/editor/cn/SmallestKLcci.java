package record.leetcode.editor.cn;

//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
//
// 示例：
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
//
//
// 提示：
//
//
// 0 <= len(arr) <= 100000
// 0 <= k <= min(100000, len(arr))
//
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 230 👎 0

import java.util.Objects;
import java.util.PriorityQueue;

public class SmallestKLcci {
	public static void main(String[] args) {
		Solution solution = new SmallestKLcci().new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int[] smallestK(int[] arr, int k) {
			// 参数检查
			if (Objects.isNull(arr) || arr.length < k) {
				return arr;
			}
			// 小顶堆
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();

			// 构造k个节点的小顶堆
			for (int j : arr) {
				minHeap.offer(j);
			}

			int[] result = new int[k];
			for (int i = 0; i < k; i++) {

				Integer poll = minHeap.poll();

				if (Objects.isNull(poll)) {
					continue;
				}

				result[i] = poll;
			}

			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
