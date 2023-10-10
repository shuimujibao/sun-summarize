package jianzhioffer;

/**
 * 请实现一个函数，把字符串s中的每个空格替换成"%20"。
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年10月10日 14:06:00
 */
public class ReplaceSpaces {

	public static void main(String[] args) {
		String s = "We are happy.";

		replace(s);
	}

	public static void replace(String s) {

		String replace = s.replace(" ", "%20");

		System.out.println(replace);

	}
}
