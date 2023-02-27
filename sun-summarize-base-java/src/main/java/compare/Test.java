package compare;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Test
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年02月27日 18:33:00
 */
public class Test {
	public static void main(String[] args) {
		Person p1 = new Person("大名", 92, "女");
		Person p2 = new Person("玲玲", 14, "男");
		Person p3 = new Person("三木", 15, "男");

		ArrayList<Person> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		Collections.sort(list);

		list.forEach(p -> System.out.println(p.toString()));
	}
}
