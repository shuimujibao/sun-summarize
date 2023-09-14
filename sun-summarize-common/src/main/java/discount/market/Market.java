package discount.market;

import lombok.Data;

/**
 * Market
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年07月18日 10:40:00
 */
@Data
public class Market {
	/**
	 * 发放状态
	 * 0 未发放 ，1 已发放
	 */
	private Integer issueStatus;

	/**
	 * 订单id
	 */
	private Long orderId;

	/**
	 * 限制金额
	 * <p>
	 * 消费满500元
	 * 消费满1000元
	 * 消费满2000元
	 */
	private Double limitAmount;

	/**
	 * 返还金额
	 * <p>
	 * 返还200元
	 * 返还500元
	 * 返还1200元
	 */
	private Double returnAmount;

	/**
	 * 券包等级
	 * 0---500元
	 * 1---1000元
	 * 2---2000元
	 */
	private Integer couponBagLevel;
}
