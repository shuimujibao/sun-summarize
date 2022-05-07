package action.strategy;

public class SecondDiscount implements Discount {
    @Override
    public int calculate(int money) {
        Double balance = money * 0.9;
        return balance.intValue();
    }
}
