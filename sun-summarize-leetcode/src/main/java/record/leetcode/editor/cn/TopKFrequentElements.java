package record.leetcode.editor.cn;

//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
//
//
//
// 示例 1:
//
//
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
//
//
// 示例 2:
//
//
//输入: nums = [1], k = 1
//输出: [1]
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 105
// k 的取值范围是 [1, 数组中不相同的元素的个数]
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
//
//
//
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列）
// 👍 1170 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
	public static void main(String[] args) {
		Solution solution = new TopKFrequentElements().new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int[] topKFrequent(int[] nums, int k) {
			// 每个数字出现的次数
			Map<Integer, Integer> frequencyForNum = new HashMap<>();
			for (int num : nums) {
				frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
			}

			// 出现次数相同的数据放到同一个桶中
			List<Integer>[] buckets = new ArrayList[nums.length + 1];
			for (int key : frequencyForNum.keySet()) {
				int frequency = frequencyForNum.get(key);
				if (buckets[frequency] == null) {
					buckets[frequency] = new ArrayList<>();
				}
				buckets[frequency].add(key);
			}

			// 导致遍历获取次数出现最多的数字
			List<Integer> topK = new ArrayList<>();
			for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
				if (buckets[i] == null) {
					continue;
				}
				if (buckets[i].size() <= (k - topK.size())) {
					// 当前桶中数据未超过k个
					topK.addAll(buckets[i]);
				} else {
					// 当前桶中数据未超过k个
					topK.addAll(buckets[i].subList(0, k - topK.size()));
				}
			}

			// 返回结果
			int[] res = new int[k];
			for (int i = 0; i < k; i++) {
				res[i] = topK.get(i);
			}
			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
