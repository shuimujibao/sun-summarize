package create.factory.abstractFactory;


import product.Bag;
import product.Fruit;

public interface AbstractFactory {
	Fruit getFruit();

	Bag getBag();
}
