package discount.order;

import lombok.Data;

import java.util.Date;

/**
 * OrderDto
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年07月18日 09:51:00
 */
@Data
public class OrderDto {
	/**
	 * 会员id
	 */
	private Long memberId;

	/**
	 * 预计、实际取还车开始时间
	 * 默认值：2023年7月14日（含）
	 */
	private Date selectStartTime;

	/**
	 * 预计、实际取还车结束时间
	 * 默认值：2023年8月31日（含）
	 */
	private Date selectEndTime;
}
