package discount;

import discount.market.Market;
import discount.market.MarketMessage;
import discount.order.Order;
import discount.order.OrderMessage;
import discount.pay.PayMessage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Calculate
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年07月18日 11:12:00
 */
public class Calculate {

	/**
	 *
	 * <p>
	 * 下单时orderId与originReceivableAmount为空
	 *
	 * @param orderId                 订单id
	 * @param originReceivableAmount  原订单应收
	 * @param currentReceivableAmount 现订单应收
	 * @return CalculateResult
	 */

	/**
	 * 计算优惠金额档位及其金额
	 *
	 * @param orderId                 订单ID
	 * @param currentReceivableAmount 当前应收
	 * @param estimatedPickupTime     预计取车时间
	 * @param pickupTime              实际取车时间
	 * @param estimatedReturnTime     预计还车时间
	 * @param returnTime              实际还车时间
	 * @return
	 */
	public CalculateResult calculatePreHandle(Long orderId, Double currentReceivableAmount,
											  Date estimatedPickupTime,
											  Date pickupTime,
											  Date estimatedReturnTime,
											  Date returnTime) {

		// 预计去换车

		// 调用营销服务
		// 已发券的直接从营销获取

		// 获取当前用户发券信息
		// 营销全量返回三个档位记录，降序返回
		MarketMessage marketMessage = new MarketMessage();
		List<Market> marketList = marketMessage.getMarketList();

		// 获取当前用户,时间范围内订单记录
		// 当前获取记录，按照已还车>已取车>未取车，实际还车时间>预计还车时间，按优先级排序；
		OrderMessage orderMessage = new OrderMessage();
		List<Order> orderMessageList = orderMessage.getOrderMessageList();

		// 获取当前用户订单列表应收记录
		orderMessageList.stream().forEach(p -> {
			PayMessage payMessage = new PayMessage();
			p.setReceivableAmount(payMessage.getDiscountsAvailableAmount());
		});

		// ====================数据前置处理=====================

		// 获取待发券档位记录
		List<Market> waitIssueList = new ArrayList<>();

		// 已发券档位记录
		List<Market> alreadyIssueList = new ArrayList<>();

		marketList.forEach(market -> {
			if (market.getIssueStatus().equals(0)) {
				waitIssueList.add(market);
			}

			if (market.getIssueStatus().equals(1)) {
				alreadyIssueList.add(market);
			}
		});

		// 移除已发券的订单记录
		List<Long> orderIdList = alreadyIssueList.stream().map(Market::getOrderId).collect(Collectors.toList());

		List<Order> waitOrderList = orderMessageList
			.stream()
			.filter(order -> !orderIdList.contains(order.getOrderId())).collect(Collectors.toList());

		// ====================优惠档位计算=====================

		if (Objects.isNull(orderId)) {
			// 下单时 订单id为空，此时原应收为0；
			// 此时未取车优先级最低,故放置列表最后
			Order order = new Order();

			waitOrderList.add(order);

			// 预计取车时间排序
		}

		// 通过两个list进行计算
		// 待发券档位记录==> waitIssueList
		// 待发券订单记录==> waitOrderList
		return calculateResult(waitIssueList, waitOrderList, orderId, null, currentReceivableAmount);
	}

	/**
	 * @param waitIssueList           待发券档位记录
	 * @param waitOrderList           待发券的订单记录
	 * @param originReceivableAmount  原订单应收
	 * @param currentReceivableAmount 现订单应收
	 * @return CalculateResult
	 */
	public CalculateResult calculateResult(List<Market> waitIssueList, List<Order> waitOrderList,
										   Long orderId, Double originReceivableAmount, Double currentReceivableAmount) {

		// 计算结果
		CalculateResult calculateResult = new CalculateResult();

		// 原优惠档位信息
		CalculateResult originReceivableResult = calculateResultOriginAndCurrent(waitIssueList, waitOrderList,
			orderId, originReceivableAmount);

		// 现优惠档位信息
		CalculateResult currentReceivableResult = calculateResultOriginAndCurrent(waitIssueList, waitOrderList,
			orderId, currentReceivableAmount);

		// 计算升档/降挡
		Double limitAmount = originReceivableResult.getLimitAmount();
		Double limitAmount1 = currentReceivableResult.getLimitAmount();

		if (Objects.isNull(limitAmount1)) {
			calculateResult.setUpShiftEnum(UpShiftEnum.NONE);
		}

		if (limitAmount1 > limitAmount) {
			calculateResult.setUpShiftEnum(UpShiftEnum.UP);
		}

		if (limitAmount1 < limitAmount) {
			calculateResult.setUpShiftEnum(UpShiftEnum.DOWN);
		}

		// 计算距离下一档位差额
		// 当前券包等级
		Integer couponBagLevel = currentReceivableResult.getCouponBagLevel();

		// 获取当前档位的上一个档位
		waitIssueList.forEach(p -> {
			if (p.getCouponBagLevel() > couponBagLevel) {
				calculateResult.setNextLimitAmount(p.getLimitAmount());
				calculateResult.setNextReturnAmount(p.getReturnAmount());
			}
		});

		return calculateResult;
	}


	/**
	 * @param waitIssueList    待发券档位记录
	 * @param waitOrderList    待发券的订单记录
	 * @param receivableAmount 订单应收
	 * @return CalculateResult
	 */
	public CalculateResult calculateResultOriginAndCurrent(List<Market> waitIssueList, List<Order> waitOrderList,
														   Long orderId, Double receivableAmount) {
		CalculateResult result = new CalculateResult();

		// 遍历优惠档，由高向低
		for (Market market : waitIssueList) {

			// 遍历订单列表，优先级由高到底
			for (Order order : waitOrderList) {

				// 不符合档位条件
				if (market.getLimitAmount() >= order.getReceivableAmount()) {
					continue;
				}

				// 符合档位条件
				if (!Objects.equals(order.getOrderId(), orderId)) {

				}

				if (Objects.equals(order.getOrderId(), orderId)) {

				}
			}
		}

		return result;
	}
}
