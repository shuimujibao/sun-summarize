package product.fruit;


import product.Fruit;
import product.bag.OrangeBag;

public class Orange implements Fruit {
	private int price = 10;

	private String name;

	public Orange(String name, int price) {
		this.price = price;
		this.name = name;
	}

	public Orange() {
	}

	public Orange(int price) {
		this.price = price;
	}

	public void pack(OrangeBag bag) {
		bag.pack();
	}

	@Override
	public void draw() {
		System.out.println(name + "创建的橘子，黄金橘  价格：" + price + "元");
	}

	@Override
	public int price() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
