package moka.third;

/**
 * long类型在数值超过128后就会去重新new对象，众所周知 == 比较的是内存地址 自然就没法比较了，所以不论大小 long类型一律用equals比较
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
