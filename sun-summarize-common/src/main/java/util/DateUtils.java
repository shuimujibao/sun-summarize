package util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtils {

	/**
	 * 时间类型格式化为字符串
	 *
	 * @param date 时间
	 * @return String
	 */
	public static String convertDateToString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}
}
