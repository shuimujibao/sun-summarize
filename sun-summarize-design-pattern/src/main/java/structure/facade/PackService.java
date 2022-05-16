package structure.facade;

import create.factory.abstractFactory.AbstractFactory;
import create.factory.abstractFactory.OrangeFactory;
import product.Bag;
import structure.decorator.CheckedBagDecorator;
import structure.decorator.ReinforceBagDecorator;
import structure.decorator.SpeedDecorator;

public class PackService {
    public void doPack() {
        AbstractFactory factory = new OrangeFactory();
        //得到包装
        Bag bag = factory.getBag();

        //增加防伪标识
        bag = new ReinforceBagDecorator(bag);
        bag = new CheckedBagDecorator(bag);
        bag = new SpeedDecorator(bag);

        bag.pack();
    }
}
