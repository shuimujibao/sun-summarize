package zijie.six;

import java.util.Objects;

/**
 * @description: 版本号比较
 * <p>
 * 比较两个版本号 version1和 version2。如果 version1>version2 返回 1，
 * 如果 version1<version2 返回 -1，除此之外返回 0。你可以假设版本字符串非空，并且只包含数字和.字符。
 * @author: xy.sun06
 * @create: 2024-07-26 09:46
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class WriteExamOne {
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
