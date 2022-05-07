package action.template;

import product.Fruit;

import java.util.List;

public class CartShoping extends ShoppingCart {
	public CartShoping(List<Fruit> products) {
		super(products);
	}

	@Override
	protected void pay(int money) {
		System.out.println("会员卡支付：" + money);
	}
}
