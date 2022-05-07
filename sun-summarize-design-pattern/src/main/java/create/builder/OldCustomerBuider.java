package create.builder;

import product.fruit.Apple;
import product.fruit.Banana;
import product.fruit.Orange;

public class OldCustomerBuider implements Builder {
	private FruitMeal fruitMeal = new FruitMeal();

	@Override
	public void buildApple(int price) {
		Apple apple = new Apple();
		apple.setPrice(price);
		fruitMeal.setApple(apple);
	}

	@Override
	public void buildBanana(int price) {
		Banana banana = new Banana();
		banana.setPrice(price);
		fruitMeal.setBanana(banana);
	}

	@Override
	public void buildOrange(int price) {
		Orange orange = new Orange();
		orange.setPrice(price);
		fruitMeal.setOrange(orange);
	}

	@Override
	public FruitMeal getFruitMeal() {
		fruitMeal.setDiscount(10);
		fruitMeal.init();
		return fruitMeal;
	}
}
