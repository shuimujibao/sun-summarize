package structure.bridge.bag;

public class MiniBag extends BagAbstraction {
    @Override
    public void pick() {
        System.out.println("采摘水果开始！");
        this.material.draw();
        System.out.println("采摘了一迷你袋！");
    }
}
