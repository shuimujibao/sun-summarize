package create.builder;

import product.fruit.Apple;
import product.fruit.Banana;
import product.fruit.Orange;

public class FruitMeal {
	private Apple apple;
	private Banana banana;
	private Orange orange;
	private int totalPrice;
	private int discount;

	public Apple getApple() {
		return apple;
	}

	public void setApple(Apple apple) {
		this.apple = apple;
	}

	public Banana getBanana() {
		return banana;
	}

	public void setBanana(Banana banana) {
		this.banana = banana;
	}

	public Orange getOrange() {
		return orange;
	}

	public void setOrange(Orange orange) {
		this.orange = orange;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int cost() {
		return this.totalPrice;
	}

	public void init() {
		if (apple != null) {
			totalPrice += apple.price();
		}
		if (orange != null) {
			totalPrice += orange.price();
		}
		if (banana != null) {
			totalPrice += banana.price();
		}
		if (totalPrice > 0) {
			totalPrice -= discount;
		}
	}

	public void showitems() {
		System.out.println("totalPrice:" + totalPrice);
	}
}
