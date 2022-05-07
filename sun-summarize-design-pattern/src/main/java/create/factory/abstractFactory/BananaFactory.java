package create.factory.abstractFactory;


import product.Bag;
import product.Fruit;
import product.bag.BananaBag;
import product.fruit.Banana;

public class BananaFactory implements AbstractFactory {
	@Override
	public Fruit getFruit() {
		return new Banana();
	}

	@Override
	public Bag getBag() {
		return new BananaBag();
	}
}
