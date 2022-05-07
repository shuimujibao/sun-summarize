package create.factory.simple;


import product.Fruit;
import product.fruit.Apple;
import product.fruit.Banana;
import product.fruit.Orange;

/**
 * @author : itw_sunxy
 * @title 设计模式
 * @description 简单工厂模式
 * @createtime : 2019/6/20 15:30
 */
public class StaticFactory {
	public static final int TYPE_APPLE = 1;
	public static final int TYPE_ORANGE = 2;
	public static final int TYPE_BANANA = 3;

	public static Fruit getFruit(int type) {
		if (TYPE_APPLE == type) {
			return new Apple();
		} else if (TYPE_ORANGE == type) {
			return new Orange();
		} else if (TYPE_BANANA == type) {
			return new Banana();
		}
		return null;
	}

	/**
	 * @title 设计模式
	 * @description 多方法工厂
	 * @author : itw_sunxy
	 * @createtime : 2019/6/20 15:25
	 */
	public static Fruit getFruitApple() {
		return new Apple();
	}

	public static Fruit getFruitOrange() {
		return new Orange();
	}

	public static Fruit getFruitBanana() {
		return new Banana();
	}
}
