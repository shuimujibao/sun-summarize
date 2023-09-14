package discount.order;

import lombok.Data;

import java.util.List;

/**
 * OrderMessage
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年07月18日 10:01:00
 */
@Data
public class OrderMessage {
	/**
	 * 订单信息列表
	 */
	private List<Order> orderMessageList;
}
