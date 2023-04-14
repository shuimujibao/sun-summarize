package alibaba.first.thread;

/**
 * 笔试题
 *
 * @summary WriteExam
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 贝壳找房（北京）科技有限公司
 * @since: 2022年04月20日 16:36:00
 */
public class WriteExam {
	public static void main(String[] args) {
		// 方法一
		Thread thread = new Thread();
		System.out.println("重命名前：" + thread.getName());
		thread.setName("小雨");
		System.out.println("重命名后：" + thread.getName());

		// 方法二
	}
}
