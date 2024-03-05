package record.leetcode.editor.cn;

//给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
//
// 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
//
// 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎
//，则可以在之后的操作中 重复使用 这枚鸡蛋。
//
// 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
//
//
// 示例 1：
//
//
//输入：k = 1, n = 2
//输出：2
//解释：
//鸡蛋从 1 楼掉落。如果它碎了，肯定能得出 f = 0 。
//否则，鸡蛋从 2 楼掉落。如果它碎了，肯定能得出 f = 1 。
//如果它没碎，那么肯定能得出 f = 2 。
//因此，在最坏的情况下我们需要移动 2 次以确定 f 是多少。
//
//
// 示例 2：
//
//
//输入：k = 2, n = 6
//输出：3
//
//
// 示例 3：
//
//
//输入：k = 3, n = 14
//输出：4
//
//
//
//
// 提示：
//
//
// 1 <= k <= 100
// 1 <= n <= 104
//
// Related Topics 数学 二分查找 动态规划
// 👍 981 👎 0

public class SuperEggDrop {
	public static void main(String[] args) {
		Solution solution = new SuperEggDrop().new Solution();


		System.out.println(solution.superEggDrop(2, 6));

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int superEggDrop(int K, int N) {
			int[][] middleResults = new int[K + 1][N + 1];

			for (int i = 1; i <= N; i++) {
				middleResults[1][i] = i; // only one egg
				middleResults[0][i] = 0; // no egg
			}

			for (int i = 1; i <= K; i++) {
				middleResults[i][0] = 0; // zero floor
			}

			for (int k = 2; k <= K; k++) { // start from two egg
				for (int n = 1; n <= N; n++) {
					int tMinDrop = N * N;
					for (int x = 1; x <= n; x++) {
						tMinDrop = Math.min(tMinDrop, 1 + Math.max(middleResults[k - 1][x - 1], middleResults[k][n - x]));
					}
					middleResults[k][n] = tMinDrop;
				}
			}

			return middleResults[K][N];
		}
//		public int superEggDrop(int k, int n) {
//			return recursive(k, n);
//		}
//
//		public int recursive(int K, int N) {
//			if (N == 0 || N == 1 || K == 1) {
//				return N;
//			}
//
//			int minimun = N;
//			for (int i = 1; i <= N; i++) {
//				int tMin = Math.max(recursive(K - 1, i - 1), recursive(K, N - i));
//				minimun = Math.min(minimun, 1 + tMin);
//			}
//			return minimun;
//		}
	}
//leetcode submit regi end(Prohibit modification and deletion)

}
