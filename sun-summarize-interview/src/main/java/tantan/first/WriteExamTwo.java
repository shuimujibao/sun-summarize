package tantan.first;

/**
 * WriteExamTwo
 *
 * @summary 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 问总共有多少条不同的路径？
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 贝壳找房（北京）科技有限公司
 * @since: 2022年05月07日 17:22:00
 */
public class WriteExamTwo {

	public int total(int m, int n) {
		//当前网格所有位置
		int[][] f = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					f[i][j] = 1;
				} else {
					f[i][j] = f[i - 1][j] + f[i][j - 1];
				}
			}
		}

		return f[m - 1][n - 1];
	}
}
