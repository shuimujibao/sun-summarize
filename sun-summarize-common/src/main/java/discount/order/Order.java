package discount.order;

import lombok.Data;

import java.util.Date;

/**
 * Order
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年07月18日 10:08:00
 */
@Data
public class Order {

	/**
	 * 订单id
	 */
	private Long orderId;

	/**
	 * 订单状态
	 */
	private Long orderStatus;

	/**
	 * 预计取车时间
	 */
	private Date estimatedPickupTime;

	/**
	 * 实际取车时间
	 */
	private Date pickupTime;

	/**
	 * 预计还车时间
	 */
	private Date estimatedReturnTime;

	/**
	 * 实际还车时间
	 */
	private Date returnTime;

	/**
	 * 订单应收
	 */
	private Double receivableAmount;
}
