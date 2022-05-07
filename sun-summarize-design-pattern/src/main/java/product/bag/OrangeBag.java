package product.bag;


import product.Bag;

public class OrangeBag implements Bag {

    @Override
    public void pack() {
        System.out.println("橘子包装");
    }
}
