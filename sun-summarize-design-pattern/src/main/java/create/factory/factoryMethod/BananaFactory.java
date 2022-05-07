package create.factory.factoryMethod;


import product.Fruit;
import product.fruit.Banana;

public class BananaFactory implements FruitFactory {
	@Override
	public Fruit getFruit() {
		return new Banana();
	}
}
