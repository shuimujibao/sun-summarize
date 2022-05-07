package product.bag;


import product.Bag;

public class BananaBag implements Bag {

    @Override
    public void pack() {
        System.out.println("香蕉包装");
    }
}
