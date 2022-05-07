package structure.composite;

/**
 * @author : itw_sunxy
 * @title 设计模式之组合模式
 * @description
 * @createtime : 2019/7/2 19:37
 */
public class CompositeClient {
    public static void main(String[] args) {
        sendFruit();
    }

    private static void sendFruit() {

        //根目录
        DistrictNode root = new DistrictNode("根");

        //一级目录
        root.addChildren(new DistrictNode("上海"));
        root.addChildren(new DistrictNode("天津"));
        DistrictNode districtNode = new DistrictNode("北京");
        root.addChildren(districtNode);

        //二级目录
        districtNode.addChildren(new DistrictNode("海淀区"));
        districtNode.addChildren(new DistrictNode("西城区"));
        DistrictNode districtNode1 = new DistrictNode("朝阳区");
        districtNode.addChildren(districtNode1);

        //三级目录
        districtNode1.addChildren(new DistrictNode("三里屯"));
        districtNode1.addChildren(new DistrictNode("朝阳外街"));

        System.out.println();
    }
}
