package structure.composite;

import java.util.ArrayList;
import java.util.List;

public class DistrictNode extends Node {
    private List<Node> children = new ArrayList<>();

    public DistrictNode(String name) {
        super(name);
    }

    @Override
    public List<Node> getChildren() {
        return children;
    }

    public void addChildren(Node node) {
        children.add(node);
    }

    public void delChildren(int i) {
        children.remove(i);
    }
}
