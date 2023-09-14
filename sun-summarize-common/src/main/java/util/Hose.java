package util;

/**
 * 首付计算
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年06月14日 18:06:00
 */
public class Hose {

	/**
	 * 贷款比例
	 */
	private final static Double LOAN_RATIO = 0.65;

	/**
	 * 二手房贷款评估比例
	 */
	private final static Double EVALUATION_RATIO = 0.98;

	/**
	 * 契税比例
	 */
	private final static Double DEED_TAX_RATIO = 0.01;

	/**
	 * 中介费比例
	 */
	private final static Double AGENCY_FEE_RATIO = 0.02;

	/**
	 * 首付计算
	 *
	 * @param total 总房款
	 * @return 首付金额
	 */
	public static Double calculate(Double total) {
		// 网签价
		Double evaluationAmount = total * EVALUATION_RATIO;

		// 以评估价计算贷款总额
		Double loanAmount = evaluationAmount * LOAN_RATIO;

		// 房价首付款
		double downPayment = total - loanAmount;

		// 契税以网签价计算
		double deedTaxAmount = evaluationAmount * DEED_TAX_RATIO;

		// 中介费以成交总价计算
		double agencyFeeAmount = total * AGENCY_FEE_RATIO;

		// 实际支出：房价首付款+契税+中介费
		return downPayment + deedTaxAmount + agencyFeeAmount;
	}

	public static void main(String[] args) {
		Double aDouble = 300d;
		System.out.println(calculate(aDouble));
	}
}
