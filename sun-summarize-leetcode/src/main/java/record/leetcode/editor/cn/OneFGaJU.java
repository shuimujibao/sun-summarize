package record.leetcode.editor.cn;

//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且
//不重复 的三元组。
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
// -10⁵ <= nums[i] <= 10⁵
//
//
//
//
//
// 注意：本题与主站 15 题相同：https://leetcode-cn.com/problems/3sum/
//
// Related Topics 数组 双指针 排序 👍 142 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OneFGaJU {
	public static void main(String[] args) {
		Solution solution = new OneFGaJU().new Solution();
		int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
		solution.threeSum(arr);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		List<List<Integer>> result = new ArrayList<>();

		public List<List<Integer>> threeSum(int[] nums) {
			// 升序排列
			Arrays.sort(nums);

			System.out.println(Arrays.toString(nums));

			// 双指针
			for (int i = 0; i < nums.length; i++) {
				if (i > 0 && nums[i] == nums[i - 1]) {
					continue;
				}
				int low = i + 1;
				int high = nums.length - 1;
				while (low < high) {
					int sum = nums[i] + nums[low] + nums[high];
					if (sum == 0) {
						List<Integer> path = new ArrayList<>();
						path.add(nums[i]);
						path.add(nums[low]);
						path.add(nums[high]);
						while (low < high && nums[low + 1] == nums[low]) {
							low++;
						}
						while (low < high && nums[high - 1] == nums[high]) {
							high--;
						}
						low++;
						high--;
						result.add(path);
					} else if (sum > 0) {
						high--;
					} else {
						low++;
					}
				}
			}

			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
