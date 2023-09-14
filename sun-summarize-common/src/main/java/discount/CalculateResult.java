package discount;

import lombok.Data;

/**
 * CalculateResult
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年07月18日 11:13:00
 */
@Data
public class CalculateResult {
	/**
	 * 优惠等级
	 */
	private UpShiftEnum upShiftEnum;

	/**
	 * 已达到限制金额
	 */
	private Double limitAmount;

	/**
	 * 券包等级
	 * 0---500元
	 * 1---1000元
	 * 2---2000元
	 */
	private Integer couponBagLevel;

	/**
	 * 可返还金额
	 */
	private Double returnAmount;

	/**
	 * 升档/降挡至限制金额
	 */
	private Double nextLimitAmount;

	/**
	 * 升档/降挡至可返还金额
	 */
	private Double nextReturnAmount;
}
