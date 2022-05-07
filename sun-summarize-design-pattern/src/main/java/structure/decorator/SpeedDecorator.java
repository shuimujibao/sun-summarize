package structure.decorator;

import product.Bag;

public class SpeedDecorator extends BagDecorator {
	public SpeedDecorator(Bag bag) {
		super(bag);
	}

	@Override
	public void pack() {
		super.pack(); //调用原有业务的方法
		speedy();
	}

	public void speedy() {
		System.out.println("----------------");
		System.out.println("快递大哥，请加急邮送！");
	}
}
