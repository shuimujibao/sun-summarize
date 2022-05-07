package structure.decorator;


import product.Bag;

public class ReinforceBagDecorator extends BagDecorator {
	public ReinforceBagDecorator(Bag bag) {
		super(bag);
	}

	@Override
	public void pack() {
		super.pack(); //调用原有业务的方法
		reinforce();
	}

	public void reinforce() {
		System.out.println("----------------");
		System.out.println("加固了包装");
	}
}
