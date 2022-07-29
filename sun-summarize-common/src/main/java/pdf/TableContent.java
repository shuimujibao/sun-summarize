package pdf;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 表格内容
 *
 * @summary TableContent
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月29日 15:09:00
 */
@Data
public class TableContent {
	/**
	 * 序号
	 */
	private Integer number;

	/**
	 * 车牌号
	 */
	private String carNumber;

	/**
	 * 短租车型
	 */
	private String carType;

	/**
	 * 入站时间
	 */
	private Date comeTime;

	/**
	 * 入站站名
	 */
	private String comeName;

	/**
	 * 出站时间
	 */
	private String goName;

	/**
	 * 出站站名
	 */
	private Date goTime;

	/**
	 * 费用里程
	 */
	private Integer distance;

	/**
	 * 金额
	 */
	private BigDecimal amount;


}
