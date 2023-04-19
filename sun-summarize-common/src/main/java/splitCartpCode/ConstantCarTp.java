package splitCartpCode;

/**
 * 解析
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年04月19日 18:37:00
 */
public class ConstantCarTp {

	public static String SQL_TEMPLATE = "INSERT INTO t_fi_dopay_cartp_relation ( order_source, receipt_type, pay_type, payment_channel, cartp_code,`desc`,`status`, create_emp,create_time,modify_emp,modify_time ) VALUES ( {0}, {1}, {2}, {3}, {4}, {5},{6},{7},{8},{9},{10});";

	public static final String DATE_SOURCE = "";
}
