package create.factory.factoryMethod;


import product.Fruit;

/**
 * @author : itw_sunxy
 * @title 设计模式--工厂方法模式
 * @description 工厂方法接口
 * @createtime : 2019/6/20 15:38
 */
public interface FruitFactory {
    Fruit getFruit(); //摘水果指令
}
