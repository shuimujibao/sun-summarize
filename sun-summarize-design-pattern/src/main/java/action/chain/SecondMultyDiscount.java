package action.chain;


public class SecondMultyDiscount extends MultyDiscount {
    public SecondMultyDiscount(MultyDiscount nextMultyDiscount) {
        super(nextMultyDiscount);
    }

    @Override
    public int calculate(int money) {
        Double balance = money * 0.9;
        return super.calculate(balance.intValue());
    }
}
