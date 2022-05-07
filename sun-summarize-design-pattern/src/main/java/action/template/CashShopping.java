package action.template;

import product.Fruit;

import java.util.List;

public class CashShopping extends ShoppingCart {
	public CashShopping(List<Fruit> products) {
		super(products);
	}

	@Override
	protected void pay(int money) {
		System.out.println("现金支付：" + money);
	}
}
