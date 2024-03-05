package record.leetcode.editor.cn;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：[]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105
//
// Related Topics 数组 双指针 排序
// 👍 4903 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static void main(String[] args) {
		Solution solution = new ThreeSum().new Solution();

//		int[] nums = new int[]{-1, 0, 1, 2, -1, -4};


		int[] nums = new int[]{-2, 0, 0, 2, 2};

		solution.threeSum(nums);

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
//		public List<List<Integer>> threeSum(int[] nums) {
//			List<List<Integer>> result = new ArrayList<>();
//			Arrays.sort(nums);
//			int len = nums.length;
//			for (int i = 0; i < len; i++) {
//				if (nums[i] > 0) {
//					return result;
//				}
//
//				if (i > 0 && nums[i] == nums[i - 1]) {
//					continue;
//				}
//				int l = i + 1;
//				int r = len - 1;
//				while (l < r) {
//					int t = nums[i] + nums[l] + nums[r];
//					if (t == 0) {
//						List<Integer> list = new ArrayList<>();
//						list.add(nums[i]);
//						list.add(nums[l]);
//						list.add(nums[r]);
//						result.add(list);
//
//						while (l < r && nums[l + 1] == nums[l]) {
//							l++;
//						}
//						while (l < r && nums[r - 1] == nums[r]) {
//							r--;
//						}
//						++l;
//						--r;
//
//					} else if (t > 0) {
//						r--;
//					} else {
//						l++;
//					}
//				}
//			}
//			return result;
//		}


		public List<List<Integer>> threeSum(int[] nums) {

			List<List<Integer>> result = new ArrayList<>();

			Arrays.sort(nums);

			for (int i = 0; i < nums.length; i++) {

				if (i > 0 && nums[i] == nums[i - 1]) {
					continue;
				}

				int leftPoint = i + 1;
				int rightPoint = nums.length - 1;

				while (leftPoint < rightPoint) {

					int sum = nums[i] + nums[leftPoint] + nums[rightPoint];

					if (sum == 0) {
						List<Integer> list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[leftPoint]);
						list.add(nums[rightPoint]);
						result.add(list);
						while (leftPoint< rightPoint && nums[leftPoint+1] == nums[leftPoint]) {
							leftPoint++;
						}
						while (leftPoint< rightPoint && nums[rightPoint-1] == nums[rightPoint]){
							rightPoint--;
						}
						leftPoint++;
						rightPoint--;
					} else if (sum < 0) {
						leftPoint++;
					} else {
						rightPoint--;
					}
				}
			}
			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
