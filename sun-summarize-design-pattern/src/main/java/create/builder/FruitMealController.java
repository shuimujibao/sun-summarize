package create.builder;

public class FruitMealController { //收银台-- 导演类
	public void construct() {
		Builder builder = new OldCustomerBuider();
		builder.buildApple(50);
		builder.buildBanana(80);
		builder.buildOrange(30);

		FruitMeal fruitMeal = builder.getFruitMeal();

		int cost = fruitMeal.cost();
		System.out.println("本套餐花费：" + cost);
	}

	public static void main(String[] args) {
		new FruitMealController().construct();
	}
}
