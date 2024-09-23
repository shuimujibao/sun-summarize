package coupang.metric;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 模板方法
 * @author: xy.sun06
 * @create: 2024-09-05 09:50
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public abstract class MetricInterface {

	/**
	 * 默认值
	 */
	Double defaultValue = 1.0;

	/**
	 * 全局Metric
	 */
	private final ConcurrentHashMap<String, Double> global = new ConcurrentHashMap<>();

	/**
	 * 上游调用自拓展处理
	 */
	abstract void customize();

	/**
	 * 公共方法统计metric，保证数据一致性
	 *
	 * @param context 请求上下文
	 */
	synchronized void count(Context context) {
		// TODO 自定义拓展
		this.customize();

		// 全局写入Metric，同时若name&&map内容作为唯一建对nums进行累加
		String weiYiKey = context.getWeiYiKey();
		Double nums = Objects.isNull(context.getNums()) ? defaultValue : context.getNums();

		// 获取当前global中的Metric
		global.put(weiYiKey, global.getOrDefault(weiYiKey, defaultValue) + nums);
	}

	/**
	 * 遍历打印所有的Metric
	 */
	void print() {
		StringBuilder sb = new StringBuilder();
		for (String next : global.keySet()) {
			Double value = global.get(next);
			sb.append(next).append(value);
		}
		System.out.println(sb);
	}
}
