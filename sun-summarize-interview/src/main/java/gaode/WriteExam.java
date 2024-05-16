package gaode;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 1.查询无效交易
 * 如果出现下述两种情况，交易 可能无效
 * 交易金额超过 ¥1000 或者它和另一个城市中同名的另一笔交易相隔不超过 60 分钟(包含 60 分钟整)
 * 每个交易字符串 transactions[i]由一些用逗号分隔的值组成，这些值分别表示交易的名称，时间(以分钟计)，金额以及城市
 * 给你一份交易清单 transactions，返回可能无效的交易列表。你可以按任何顺序返回答案。
 * <p>
 * 提示:
 * transactions.length <= 1000
 * 每笔交易 transactions[i]按"{name},{time},{amount},{city}”的格式进行记录每个交易名称{name}和城市{city}都由小写英文字母组成，长度在 1 到 10 之间
 * 每个交易时间{time} 由一些数字组成，表示一个 0到 1000 之间的整数每笔交易金额!{amount} 由一些数字组成，表示一个 0到 2000 之间的整数
 *
 * @description: 笔试题
 * @author: xy.sun06
 * @create: 2024-05-16 13:55
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class WriteExam {

	public List<String> search(String[] transactions) {
		// 返回值
		List<String> result = new ArrayList<>();

		// Hash表-> key为交易名称，value为当前交易信息
		HashMap<String, String> hashMap = new HashMap<>();

		for (String transaction : transactions) {

			String[] split = transaction.split(",");

			String name = split[0];
			Integer time = Integer.valueOf(split[1]);
			int amount = Integer.parseInt(split[2]);
			String city = split[3];

			String otherTransaction = hashMap.get(name);

			if (StringUtils.isNotBlank(otherTransaction)) {
				// 存在同名交易
				String[] otherSplit = transaction.split(",");

				Integer othersTime = Integer.valueOf(otherSplit[1]);
				String othersCity = split[3];

				// 只处理不同城市
				if (!othersCity.equals(city) && (othersTime - time) < 60) {
					result.add(transaction);
					result.add(otherTransaction);
					continue;
				}
			}

			hashMap.put(name, transaction);

			if (amount > 1000) {
				result.add(transaction);
			}

		}

		return result;
	}
}
