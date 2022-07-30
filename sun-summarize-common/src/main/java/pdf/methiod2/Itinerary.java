package pdf.methiod2;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * ETC费用行程单
 *
 * @summary Itinerary
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月29日 15:06:00
 */
@Data
public class Itinerary {

	/**
	 * 订单号
	 */
	private Integer orderNo;

	/**
	 * 承租人姓名
	 */
	private String rentName;

	/**
	 * 申请时间
	 */
	private Date applyTime;

	/**
	 * 交易金额
	 */
	private BigDecimal amount;

	/**
	 * 表格内容列表
	 */
	private List<TableContent> tableContentList;

}
