package discount;

import java.util.ArrayList;

/**
 * Test
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年07月20日 08:55:00
 */
public class Test {

	public static void main(String[] args) {
		ArrayList list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add(null);

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
			if (list.get(i) == "b"){
				list.remove("b");
			}

			if (list.get(i) == "c"){
				list.remove("c");
			}

			if (list.get(i) ==  null){
				list.remove(null);
			}
		}

		System.out.println(list);
	}
}
