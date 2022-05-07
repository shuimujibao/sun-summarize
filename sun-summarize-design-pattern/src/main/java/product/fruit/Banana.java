package product.fruit;


import product.Fruit;

public class Banana implements Fruit {
	private int price = 30;

	public Banana() {
	}

	public Banana(int price) {
		this.price = price;
	}

	@Override
	public void draw() {
		System.out.println("我是香蕉，仙人蕉");
	}

	@Override
	public int price() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
