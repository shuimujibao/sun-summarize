package pdf.method3.fill;

import java.util.Map;

/**
 * 数据内容填充动作
 *
 * @summary Fill
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月30日 14:10:00
 */
public interface Fill {

	/**
	 * 填充动作
	 *
	 * @param data 数据源头
	 */
	void action(Map<String, String> data);
}
