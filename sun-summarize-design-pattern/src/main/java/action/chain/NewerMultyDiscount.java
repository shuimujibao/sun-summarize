package action.chain;


public class NewerMultyDiscount extends MultyDiscount {
    public NewerMultyDiscount(MultyDiscount nextMultyDiscount) {
        super(nextMultyDiscount);
    }

    @Override
    public int calculate(int money) {
        Double balance = money - 30.0;
        money = balance.intValue();
        return super.calculate(money);
    }
}
