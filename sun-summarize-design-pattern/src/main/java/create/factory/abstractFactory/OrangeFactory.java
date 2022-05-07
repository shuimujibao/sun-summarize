package create.factory.abstractFactory;


import product.Bag;
import product.Fruit;
import product.bag.OrangeBag;
import product.fruit.Orange;

public class OrangeFactory implements AbstractFactory {
	@Override
	public Fruit getFruit() {

		return new Orange("孙晓宇", 90);
	}

	@Override
	public Bag getBag() {

		return new OrangeBag();
	}
}
