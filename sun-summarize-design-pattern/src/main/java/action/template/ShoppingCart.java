package action.template;

import action.strategy.Discount;
import product.Fruit;

import java.util.ArrayList;
import java.util.List;

public abstract class ShoppingCart {
	List<Fruit> products = new ArrayList<>();
	Discount discount;

	public ShoppingCart(List<Fruit> products) {
		this.products = products;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public void submitOrder() {
		int money = balance();
		System.out.println("需要支付的总金额：" + money + "元");
		//策略模式进行打折
		money = discount.calculate(money);
		pay(money);

		sendHome();
	}

	protected void sendHome() {
		System.out.println("三公里内免费送货！");
	}

	protected abstract void pay(int money);

	protected int balance() {
		int money = 0;
		for (Fruit fruit :
			products) {
			money += fruit.price();
		}
		return money;
	}
}
