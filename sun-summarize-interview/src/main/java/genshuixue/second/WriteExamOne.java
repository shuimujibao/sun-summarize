package genshuixue.second;

import com.alibaba.fastjson.JSONObject;

/**
 * @description: 解析数据
 * @author: xy.sun06
 * @create: 2024-04-01 08:20
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class WriteExamOne {

	public static void main(String[] args) {
		// 数据源
		String data = DataSource.data;

		DirectoryVo directoryVo = JSONObject.parseObject(data, DirectoryVo.class);

		System.out.println(1);

	}
}
