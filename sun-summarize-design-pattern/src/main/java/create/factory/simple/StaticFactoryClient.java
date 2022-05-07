package create.factory.simple;


import product.Fruit;

public class StaticFactoryClient {
	public static void main(String[] args) {
		peterDo();
	}

	//皮特吃苹果
	private static void peterDo() {
		Fruit fruit = StaticFactory.getFruit(StaticFactory.TYPE_BANANA);
		//Fruit fruit = new Apple();
		fruit.draw();
	}
}
