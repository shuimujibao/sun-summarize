package record.leetcode.editor.cn;

//给定一个含有 n 个正整数的数组和一个正整数 target 。
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。
//
//
//
// 示例 1：
//
//
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
//
//
// 示例 2：
//
//
//输入：target = 4, nums = [1,4,4]
//输出：1
//
//
// 示例 3：
//
//
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= target <= 109
// 1 <= nums.length <= 105
// 1 <= nums[i] <= 105
//
//
//
//
// 进阶：
//
//
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
//
// Related Topics 数组 二分查找 前缀和 滑动窗口
// 👍 1153 👎 0

public class MinimumSizeSubarraySum {
	public static void main(String[] args) {
		Solution solution = new MinimumSizeSubarraySum().new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
//	阅读完题目后最容易想到的就是暴力解法，直接用两个for循环把所有情况都枚举一遍，
//	保存满足情况的最小长度就行。但是仔细思考后发现暴力枚举会造成很多不必要的重复工作，
//	比如说当nums[i]到nums[j]的和已经大于或等与target时就没有必要枚举nums[i]到nums[j + n]的和了；
//	或者当nums[i]到nums[j]的和已经和已经小于target时，也就没有必要枚举nums[i + n]到nums[j]（i + n < j）的和了。

//	因此，为了避免这些重复工作，我们可以维持一个滑动窗口（nums[left]到nums[right]），
//	定义两个指针left和right分别表示子数组（滑动窗口窗口）的开始位置和结束位置，
//	维护变量sum存储子数组中的元素和（即从nums[left]到nums[right]的元素和）。初始状态下，left和right都指向下标0，
//	当sum<target时，将nums[right]的值加入sum中，并将指针right向右移动；
//	当sum>=target时，更新子数组的最小长度（子数组的长度为right - left + 1），并减去nums[left]的值，将left的值向右移动，直到sum<target，具体代码如下。


	class Solution {
		public int minSubArrayLen(int target, int[] nums) {
			int sum = 0;

			int length = nums.length;

			// 计算整个数组的和，判断是否存在符合条件的子数组
			for (int num : nums) {
				sum += num;
			}

			// 整个数组的和小于target,说明不存在符合条件的子数组，返回0
			if (sum < target) {
				return 0;
			} else {
				sum = 0;
			}

			int minLength = length;

			//定义滑动窗口两个指针，初始值都为0
			int left = 0, right = 0;

			//当右指针指向数组末尾时表示所有情况遍历完成
			while (right < length) {

				//将nums[right]的值加入sum中，并将指针right向右移动
				sum += nums[right];

				//当sum>=target时，更新子数组的最小长度（子数组的长度为right - left + 1），
				// 并减去nums[left]的值，将left的值向右移动，直到sum<target
				while (sum >= target) {
					//更新子数组的最小长度
					minLength = Math.min(minLength, right - left + 1);
					//减去nums[left]的值
					sum -= nums[left];
					//将left的值向右移动
					left++;
				}
				right++;
			}
			return minLength;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
