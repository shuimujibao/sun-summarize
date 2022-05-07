package structure.decorator;


import product.Bag;

public class CheckedBagDecorator extends BagDecorator {
	public CheckedBagDecorator(Bag bag) {
		super(bag);
	}

	@Override
	public void pack() {
		super.pack(); //调用原有业务的方法
		checked(); //打印防伪业务标识
	}

	public void checked() {
		System.out.println("----------------");
		System.out.println("打印上防伪标识");
	}
}
