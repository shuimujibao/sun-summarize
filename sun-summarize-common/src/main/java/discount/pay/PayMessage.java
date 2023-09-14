package discount.pay;

import lombok.Data;

/**
 * PayMessage
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年07月18日 11:29:00
 */
@Data
public class PayMessage {

	/**
	 * 当前订单可参与优惠金额
	 */
	private Double discountsAvailableAmount;
}
