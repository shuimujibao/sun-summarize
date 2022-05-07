package action.strategy;

public class NewerDiscount implements Discount {
    @Override
    public int calculate(int money) {
        Double balance = money - 30.0;
        return balance.intValue();
    }
}
