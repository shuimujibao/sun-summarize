package structure.facade;

import structure.bridge.bag.BagAbstraction;
import structure.bridge.bag.SmallBag;
import structure.bridge.material.Material;
import structure.bridge.material.Paper;

public class PickService {
    public void doPick() {
        //袋子型号
        BagAbstraction bag = new SmallBag();

        //袋子材质
        Material material = new Paper();

        bag.setMaterial(material);

        //开始采摘
        bag.pick();
    }

    public void doOther() {
        System.out.println("其他服务！");
    }
}
