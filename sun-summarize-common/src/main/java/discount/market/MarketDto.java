package discount.market;

import lombok.Data;

/**
 * MarketDto
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年07月18日 10:30:00
 */
@Data
public class MarketDto {
	/**
	 * 用户id
	 */
	private Long memberId;

	/**
	 * 订单id
	 */
	private Long orderId;
}
