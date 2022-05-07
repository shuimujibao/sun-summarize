package action.chain;


public class FullMultyDiscount extends MultyDiscount {
	public FullMultyDiscount(MultyDiscount nextMultyDiscount) {
		super(nextMultyDiscount);
	}

	@Override
	public int calculate(int money) {
		Double balance;
		balance = Double.valueOf(money);
		if (money > 50) {
			balance = money - 20.0;
		}
		return super.calculate(balance.intValue());
	}
}
