package pdf.method3;

import java.util.*;

/**
 * Test
 *
 * @summary Test
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月30日 13:26:00
 */
public class Test {

	public static final Map<String, String> data = new HashMap<>();

	static {
		data.put("order_id", "121214434");
		data.put("rent_name", "孙晓宇");
		data.put("apply_time", new Date().toString());
		data.put("amount", "11.34");
	}

	public static void main(String[] args) {
		//表格 一行数据是一个list
		List<String> list = new ArrayList<>();
		list.add("序号");
		list.add("车牌号");
		list.add("入站时间");
		list.add("入口站名");
		list.add("出站时间");
		list.add("出口站名");
		list.add("费用里程");
		list.add("金额");

		List<List<String>> List = new ArrayList<>();
		List.add(list);


		for (int i = 0; i < 100; i++) {
			List<String> list2 = new ArrayList<>();
			list2.add("1");
			list2.add("2");
			list2.add("3");
			list2.add("4");
			list2.add("4");
			list2.add("5");
			list2.add("6");
			list2.add("6");
			List.add(list2);
		}


		Map<String, List<List<String>>> listMap = new HashMap<>();
		listMap.put("eventList", List);

		Map<String, Object> o = new HashMap<>();
		o.put("list", listMap);
		o.putAll(data);

		CreateETCPdf.create(o);
	}
}
