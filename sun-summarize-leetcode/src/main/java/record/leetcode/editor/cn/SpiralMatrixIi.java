package record.leetcode.editor.cn;

//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 20
//
//
// Related Topics 数组 矩阵 模拟 👍 1269 👎 0

public class SpiralMatrixIi {
	public static void main(String[] args) {
		Solution solution = new SpiralMatrixIi().new Solution();

		solution.generateMatrix(3);

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		/**
		 * 1、对矩阵第一圈有先向右添加n个数，
		 * 再向下添加n-1个数，
		 * 再向左添加n-1个数，
		 * 再向上添加n-2个数，
		 * <p>
		 * 2、之后再进行第二圈的赋值，
		 * 第二圈和第一圈的区别就在于
		 * 第二圈行和列添加的数的个数都比第一圈少2，
		 * 所以第二圈先向右添加n-2个数，
		 * 再想左添加（n-2）-1个数以此类推，
		 * <p>
		 * 3、当num=n的平方时结束循环
		 *
		 * @param n
		 * @return
		 */
		public int[][] generateMatrix(int n) {
			int[][] res = new int[n][n];
			int num = 1;
			int i = 0;
			int j = 0;
			int r = n;
			while (num <= n * n) {
				int m1 = 1;
				while (m1 <= r) {
					res[j][i++] = num++;
					m1++;
				}
				i--;
				j++;
				int m2 = 1;
				while (m2 < r) {
					res[j++][i] = num++;
					m2++;
				}
				j--;
				i--;
				int m3 = 1;
				while (m3 < r) {
					res[j][i--] = num++;
					m3++;
				}
				i++;
				j--;
				int m4 = 1;
				while (m4 < r - 1) {
					res[j--][i] = num++;
					m4++;
				}
				j++;
				i++;
				r -= 2;
			}
			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
