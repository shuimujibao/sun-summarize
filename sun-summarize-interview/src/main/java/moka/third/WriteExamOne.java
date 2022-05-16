package moka.third;

/**
 * 输入2个Q串，返回一个字符串，其值是两个数字字符串的相加结果。
 * 如：输入"123"和"4567"，返回"4690"，不能 int 强转
 *
 * @summary WriteExamOne
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 贝壳找房（北京）科技有限公司
 * @since: 2022年05月16日 21:22:00
 */
public class WriteExamOne {

	public static void main(String[] args) {
		String a = "123";
		String b = "24";
		System.out.println(WriteExamOne.addStrings(a, b));
	}

	private static String addStrings(String num1, String num2) {
		if (num1 == null || num2 == null) {
			return null;
		}
		char[] numChar1 = num1.toCharArray();
		char[] numChar2 = num2.toCharArray();
		int i = numChar1.length;
		int j = numChar2.length;
		int add = 0;
		StringBuilder builder = new StringBuilder();

		while (i > 0 || j > 0 || add > 0) {

			int tem = add;
			if (i > 0) {
				i--;
				tem = tem + num1.charAt(i) - '0';
			}

			if (j > 0) {
				j--;
				tem = tem + num2.charAt(j) - '0';
			}

			add = tem / 10;

			builder.append(tem % 10);
		}
		return builder.reverse().toString();
	}
}
