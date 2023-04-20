package splitCartpCode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import util.DateUtils;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Map;

/**
 * 解析
 *
 * @author: xy.sun06@zuche.com
 * @Copyright (c) 2023, © 神州租车（北京）科技有限公司
 * @since: 2023年04月19日 18:39:00
 */
@SuppressWarnings("unchecked")
public class Test {

	public static void main(String[] args) {


		Map<String, JSONArray> maps = (Map) JSON.parse(ConstantCarTp.DATE_SOURCE);

		for (Map.Entry<String, JSONArray> entry : maps.entrySet()) {
			// 订单来源_收款方式_支付方式_支付通道
			String key = entry.getKey();
			String[] s = key.split("_");

			String orderSource = s[0];
			String receiptType = s[1];
			String payType = s[2];
			String paymentChannel = s[3];

			// carTp编码_商户号_描述
			JSONArray values = entry.getValue();

			String desc = "";
			StringBuilder stringBuilder = new StringBuilder();
			for (Object object : values) {
				JSONObject jsonObject = (JSONObject) object;
				desc = (String) jsonObject.get("desc");
				Integer carTpCode = (Integer) jsonObject.get("cartpCode");
				stringBuilder.append(carTpCode).append(",");
			}

			// 参数处理
			String carTpCodes = stringBuilder.toString().substring(0, stringBuilder.length() - 1);
			desc = String.format("'%s'", desc);

			// 系统参数
			Integer status = 1;
			BigDecimal create_emp = new BigDecimal(1);
			BigDecimal modify_emp = new BigDecimal(1);
			String current_time = String.format("'%s'", DateUtils.convertDateToString(new Date()));

			// 拼接sql
			String sql = MessageFormat.format(ConstantCarTp.SQL_TEMPLATE, orderSource, receiptType, payType, paymentChannel, carTpCodes, desc,
				status, create_emp, current_time, modify_emp, current_time);

			System.out.println(sql);
		}
	}
}
