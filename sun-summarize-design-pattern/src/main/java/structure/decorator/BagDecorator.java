package structure.decorator;

import product.Bag;

public class BagDecorator implements Bag {
	private Bag bag; //维持一个对抽象构件对象的引用

	public BagDecorator(Bag bag) { //注入一个构件类型的对象
		this.bag = bag;
	}

	@Override
	public void pack() {
		bag.pack();
	}
}
