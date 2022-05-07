package action.strategy;

public class FullDiscount implements Discount {
    @Override
    public int calculate(int money) {
        Double balance;
        balance = Double.valueOf(money);
        if (money > 50) {
            balance = money - 20.0;
        }
        return balance.intValue();
    }
}
