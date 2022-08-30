package util;

import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.client5.http.fluent.Response;

import java.io.IOException;

/**
 * HttpClient5GetFluent
 *
 * @summary HttpClient5GetFluent
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年08月25日 09:20:00
 */
public class HttpClient5GetFluent {

	public static void main(String[] args) {
		System.out.println(get("http://api.sap.zuche.com/ucarsap/getCheckInfoList?employeeCode=10006603&beginDate=2022-06-22&endDate=2022-07-15"));
	}

	public static String get(String url) {
		String result = null;
		try {
			Response response = Request.get(url).execute();
			result = response.returnContent().asString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
