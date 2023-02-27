package compare;

import lombok.Data;
import lombok.ToString;

/**
 * Person
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年02月27日 18:31:00
 */
@Data
@ToString
public class Person implements Comparable<Person> {
	private String name;
	private int age;
	private String sex;

	Person(String name, int age, String sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	@Override
	public int compareTo(Person person) {
		return this.getAge() - person.getAge();
	}
}
