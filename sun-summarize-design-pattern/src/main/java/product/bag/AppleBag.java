package product.bag;


import product.Bag;

public class AppleBag implements Bag {

    @Override
    public void pack() {
        System.out.println("苹果包装");
    }
}
