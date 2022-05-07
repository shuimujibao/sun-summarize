package create.factory.abstractFactory;


import product.Bag;
import product.Fruit;
import product.bag.AppleBag;
import product.fruit.Apple;

public class AppleFactory implements AbstractFactory {
	@Override
	public Fruit getFruit() {
		return new Apple();
	}

	@Override
	public Bag getBag() {
		return new AppleBag();
	}
}
