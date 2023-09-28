package record;

/**
 * 判断一个数字是哪两个连续斐波那契额数的乘积
 * <p>
 * prod = F（N）*F(N+1)
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年09月27日 18:23:00
 */
public class JudeFbMu {

	public static void main(String[] args) {
		// 目标值
		int prod = 714;

		// 索引
		int index = 1;

		// 乘积
		int muValue = 0;

		// 获取目标组合
		while (muValue < prod) {

			int m = fbValue(index);
			int n = fbValue(index + 1);

			muValue = m * n;

			if (muValue == prod) {
				System.out.println("result1: " + (index + 1)
					+ "result2:" + (index + 2));
				break;
			}

			index++;
		}

	}

	/**
	 * 获取当前函数值
	 *
	 * @param n F(n)
	 * @return int
	 */
	private static int fbValue(int n) {
		int[] dp = new int[n + 2];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
}
