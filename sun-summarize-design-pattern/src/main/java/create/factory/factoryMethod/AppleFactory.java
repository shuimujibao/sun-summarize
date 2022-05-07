package create.factory.factoryMethod;


import product.Fruit;
import product.fruit.Apple;

public class AppleFactory implements FruitFactory {
	@Override
	public Fruit getFruit() {
		return new Apple();
	}
}
