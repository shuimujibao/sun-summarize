package didi.forth.one.paystyle;


import didi.forth.one.PayStyleInterface;

/**
 * @description: 现金支付
 * @author: xy.sun06
 * @create: 2024-09-05 15:16
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class CashPay implements PayStyleInterface {
	@Override
	public void payStyle() {
		System.out.println("这是现金支付");
	}
}
