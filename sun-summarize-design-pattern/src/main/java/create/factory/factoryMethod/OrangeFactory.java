package create.factory.factoryMethod;


import product.Fruit;
import product.fruit.Orange;

public class OrangeFactory implements FruitFactory {
	@Override
	public Fruit getFruit() {
		return new Orange();
	}
}
