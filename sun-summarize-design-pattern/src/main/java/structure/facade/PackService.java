package structure.facade;

import designpatterns.create.factory.abstractFactory.AbstractFactory;
import designpatterns.create.factory.abstractFactory.OrangeFactory;
import designpatterns.product.Bag;
import designpatterns.structure.decorator.CheckedBagDecorator;
import designpatterns.structure.decorator.ReinforceBagDecorator;
import designpatterns.structure.decorator.SpeedDecorator;

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
