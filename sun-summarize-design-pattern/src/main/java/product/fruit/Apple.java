package product.fruit;


import product.Fruit;

public class Apple implements Fruit {
    private int price = 100;

    public Apple() {
    }

    public Apple(int price) {
        this.price = price;
    }

    @Override
    public void draw() {
        System.out.println("我是苹果，红富士");
    }

    @Override
    public int price() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
