package moka.third;

/**
 * WriteExamTwo
 *
 * @summary WriteExamTwo
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 贝壳找房（北京）科技有限公司
 * @since: 2022年05月16日 21:22:00
 */
public class WriteExamTwo {

	public static void main(String[] args) {
		Long a = 100L;
		Long b = 100L;
		System.out.println(a == b);

		Long c = 1000L;
		Long d = 1000L;
		System.out.println(c == d);

		// true
		System.out.println(new Long(0).equals(0));


	}
}
