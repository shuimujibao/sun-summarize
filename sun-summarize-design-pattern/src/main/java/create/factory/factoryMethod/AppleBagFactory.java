package create.factory.factoryMethod;


import product.Bag;
import product.bag.AppleBag;

public class AppleBagFactory implements BagFactory {
	@Override
	public Bag getBag() {
		return new AppleBag();
	}
}
