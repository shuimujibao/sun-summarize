package create.factory.factoryMethod;


import product.Bag;
import product.bag.BananaBag;

public class BananaBagFactory implements BagFactory {
	@Override
	public Bag getBag() {
		return new BananaBag();
	}
}
