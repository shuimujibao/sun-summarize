package record.leetcode.editor.cn;
//给你两个 版本号字符串 version1 和 version2 ，请你比较它们。版本号由被点 '.' 分开的修订号组成。修订号的值 是它 转换为整数 并忽略
//前导零。
//
// 比较版本号时，请按 从左到右的顺序 依次比较它们的修订号。如果其中一个版本字符串的修订号较少，则将缺失的修订号视为 0。
//
// 返回规则如下：
//
//
// 如果 version1 < version2 返回 -1，
// 如果 version1 > version2 返回 1，
// 除此之外返回 0。
//
//
//
//
// 示例 1：
//
//
// 输入：version1 = "1.2", version2 = "1.10"
//
//
// 输出：-1
//
// 解释：
//
// version1 的第二个修订号为 "2"，version2 的第二个修订号为 "10"：2 < 10，所以 version1 < version2。
//
// 示例 2：
//
//
// 输入：version1 = "1.01", version2 = "1.001"
//
//
// 输出：0
//
// 解释：
//
// 忽略前导零，"01" 和 "001" 都代表相同的整数 "1"。
//
// 示例 3：
//
//
// 输入：version1 = "1.0", version2 = "1.0.0.0"
//
//
// 输出：0
//
// 解释：
//
// version1 有更少的修订号，每个缺失的修订号按 "0" 处理。
//
//
//
// 提示：
//
//
// 1 <= version1.length, version2.length <= 500
// version1 和 version2 仅包含数字和 '.'
// version1 和 version2 都是 有效版本号
// version1 和 version2 的所有修订号都可以存储在 32 位整数 中
//
//
// Related Topics双指针 | 字符串
//
// 👍 422, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

import java.util.Objects;

public class CompareVersionNumbers {
	public static void main(String[] args) {
		Solution solution = new CompareVersionNumbers().new Solution();
		String version1 = "1.0";
		String version2 = "1.0.0.0";

		solution.compareVersion(version1, version2);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		/**
		 * 版本号比较
		 * <p>
		 * String version1 = "1.01";
		 * String version2 = "1.001";
		 * 返回值0
		 * <p>
		 * String version1 = "1.1.2.2";
		 * String version2 = "1.22";
		 * 返回值-1
		 * <p>
		 * String version1 = "1.00.2";
		 * String version2 = "1.0002.1";
		 * 返回值-1
		 *
		 * @param version1 版本1
		 * @param version2 版本2
		 * @return int
		 */
		public int compareVersion(String version1, String version2) {
			if (Objects.equals(version1, version2)) {
				return 0;
			}

			if (Objects.isNull(version1) || Objects.isNull(version2)) {
				return 0;
			}

			String[] versionNums1 = version1.split("\\.");
			String[] versionNums2 = version2.split("\\.");

			int index = 0;
			while (index < versionNums1.length || index < versionNums2.length) {

				int num1 = Integer.parseInt(index >= versionNums1.length ? "0" : versionNums1[index]);
				int num2 = Integer.parseInt(index >= versionNums2.length ? "0" : versionNums2[index]);

				if (Objects.equals(num1, num2)) {
					index++;
					continue;
				}

				if (num1 > num2) {
					return 1;
				}

				if (num1 < num2) {
					return -1;
				}
				index++;
			}
			return 0;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
