package action.template;

import product.Fruit;

import java.util.List;

public class OnlineShopping extends ShoppingCart {
	public OnlineShopping(List<Fruit> products) {
		super(products);
	}

	@Override
	protected void pay(int money) {
		System.out.println("支付宝/微信支付：" + money);
	}
}
