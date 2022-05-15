package structure.bridge;

import structure.bridge.bag.BagAbstraction;
import structure.bridge.bag.SmallBag;
import structure.bridge.material.Material;
import structure.bridge.material.Paper;

/**
 * @author : itw_sunxy
 * @title 设计模式之桥接模式
 * @description
 * @createtime : 2019/7/2 19:36
 */
public class BridgeClient {
    public static void main(String[] args) {
        //袋子型号
        BagAbstraction bag = new SmallBag();

        //袋子材质
        Material material = new Paper();

        bag.setMaterial(material);

        //开始采摘
        bag.pick();
    }
}
