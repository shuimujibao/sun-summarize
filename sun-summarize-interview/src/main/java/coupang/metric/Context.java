package coupang.metric;

import lombok.Data;

import java.util.HashMap;
import java.util.Objects;

/**
 * @description: 上下文
 * @author: xy.sun06
 * @create: 2024-09-05 09:48
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
@Data
public class Context {
	/**
	 * 当前Metric名称
	 */
	private String name;

	/**
	 * 当前Metric对应的内容
	 */
	private HashMap<String, String> map;

	/**
	 * 数据
	 */
	private Double nums;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Context context = (Context) o;
		return Objects.equals(name, context.name)
			&& Objects.equals(map, context.map)
			&& Objects.equals(nums, context.nums);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, map, nums);
	}

	/**
	 * 构造唯一键
	 *
	 * @return String
	 */
	public String getWeiYiKey() {
		StringBuilder sb = new StringBuilder();
		sb.append(name).append("_");

		for (String next : map.keySet()) {
			String value = map.get(next);
			sb.append(next).append(value);
		}
		return sb.toString();
	}
}
