package create.factory.factoryMethod;


import product.Bag;
import product.bag.OrangeBag;

public class OrangeBagFactory implements BagFactory {

	@Override
	public Bag getBag() {
		return new OrangeBag();
	}
}
