package meituan.third;

/**
 * @description: 大数相减
 * @author: xy.sun06
 * @create: 2024-08-09 21:25
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class ExamOne {
	public static void main(String[] args) {
		String a = "1123";
		String b = "11";
		String subtraction = subtraction(a, b);

		System.out.printf(subtraction);
	}

	public static String subtraction(String a, String b) {
		char[] num1 = a.toCharArray();
		char[] num2 = b.toCharArray();

		int length1 = num1.length - 1;
		int length2 = num2.length - 1;

		StringBuilder sb = new StringBuilder();

		// 是否需要进位
		boolean isBorrow = false;


		while (length1 > 0 || length2 > 0) {
			int residue = 0;
			// num2有剩余
			if (length1 < 0) {
				if (isBorrow) {
					residue = num2[length2] - 1;
					isBorrow = false;
				}
				sb.append(residue);
				continue;
			}

			// num1有剩余，此时为正数
			if (length2 < 0) {
				if (isBorrow) {
					residue = num1[length1] - 1;
					isBorrow = false;
				}
				sb.append(residue);
				continue;
			}

			// 被减数，可能需借位
			int minuend = isBorrow ? num1[length1] - 1 : num1[length1];

			// 减数
			int subtrahend = num2[length2];

			if (subtrahend > minuend) {
				minuend = minuend + 10;
				isBorrow = true;
			} else {
				isBorrow = false;
			}

			int diff = minuend - subtrahend;

			sb.append(diff);

			length1--;
			length2--;
		}

		return sb.reverse().toString();
	}
}
