package pdf.method1;

import java.io.*;

/**
 * GetTemplate
 *
 * @summary GetTemplate
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月29日 19:19:00
 */
public class GetTemplate {

	/**
	 * 读取PDF模板
	 *
	 * @return byte[] 字节流
	 */
	static byte[] option() throws FileNotFoundException {
		InputStream resourceAsStream = new FileInputStream("/Users/tal/IdeaProjects/workspace/sun-summarize/sun-summarize-common/src/main/java/pdf/method1/model/ETC_TEMPLATE.pdf");
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		int n = 0;
		try {
			while (-1 != (n = resourceAsStream.read(buffer))) {
				output.write(buffer, 0, n);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException ne) {
			//windows系统下只打异常不影响启动
			if (System.getProperties().getProperty("os.name").toUpperCase().contains("WINDOWS")) {
				ne.printStackTrace();
			}
			//非windows系统抛出去
			throw ne;
		}
		return output.toByteArray();
	}
}
