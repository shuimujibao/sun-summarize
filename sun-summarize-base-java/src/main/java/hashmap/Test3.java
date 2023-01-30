package hashmap;

/**
 * Test3
 *
 * @summary Test3
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年01月29日 14:52:00
 */
public class Test3 {
	public static void main(String[] args) {
		Student student = new Student();
		student.setYes(null);
		if (student.getYes() == 2) {

		}
	}

	static class Student {
		Integer yes;

		public Integer getYes() {
			return yes;
		}

		public void setYes(Integer yes) {
			this.yes = yes;
		}
	}
}
