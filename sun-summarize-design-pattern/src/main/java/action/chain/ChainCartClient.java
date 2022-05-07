package action.chain;

import action.template.CartShoping;
import action.template.ShoppingCart;
import create.factory.simple.StaticFactory;
import product.Fruit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : itw_sunxy
 * @title 设计模式之责任琏模式
 * @description
 * @createtime : 2019/7/2 19:47
 */
public class ChainCartClient {
	private static MultyDiscount multyDiscount;

	static {
		multyDiscount = new FullMultyDiscount(multyDiscount);
		multyDiscount = new NewerMultyDiscount(multyDiscount);
		multyDiscount = new SecondMultyDiscount(multyDiscount);
	}

	public static void main(String[] args) {
		List<Fruit> products = new ArrayList<>();
		products.add(StaticFactory.getFruitApple());
		products.add(StaticFactory.getFruitBanana());
		products.add(StaticFactory.getFruitOrange());

		ShoppingCart cart = new CartShoping(products);
		cart.setDiscount(multyDiscount);
		cart.submitOrder();
	}
}
