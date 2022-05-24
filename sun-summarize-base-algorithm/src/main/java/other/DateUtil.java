package other;

/**
 * DateUtil
 *
 * @summary DateUtil
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 贝壳找房（北京）科技有限公司
 * @since: 2022年05月24日 22:01:00
 */
public class DateUtil {

	public static int dayOfYear(int year, int month, int day) {
		int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if (isLeapYear(year)) {
			days[1] = 29;

		}
		for (int i = 0; i < month - 1; i++) {
			day += days[i];
		}
		return day;
	}

	private static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;

	}
}
