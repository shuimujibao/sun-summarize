package record.leetcode.editor.cn;

//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
// 说明：
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
// 示例 1:
//
// 输入: [2,2,1]
//输出: 1
//
//
// 示例 2:
//
// 输入: [4,1,2,1,2]
//输出: 4
// Related Topics 位运算 数组
// 👍 2465 👎 0

public class SingleNumber {
	public static void main(String[] args) {
		Solution solution = new SingleNumber().new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		/**
		 * 1.任意一个数和0异或仍然为自己：a⊕0 = a
		 * 2.任意一个数和自己异或是0：a⊕a=0
		 * 3.异或操作满足交换律和结合律：a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
		 *
		 * @param nums
		 * @return
		 */
		public int singleNumber(int[] nums) {
			int result = 0;
			for (int num : nums) {
				result ^= num;
			}
			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
