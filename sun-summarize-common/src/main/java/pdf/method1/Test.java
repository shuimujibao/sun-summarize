package pdf.method1;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Test
 *
 * @summary Test
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月29日 19:18:00
 */
public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		// pdf模板
		byte[] option = GetTemplate.option();

		// 填充数据
		byte[] bytes = GenerateChinesePDF.generateChinesePDF(option);

		// 写入本地
		File file = new File("/Users/tal/IdeaProjects/workspace/sun-summarize/sun-summarize-common/src/main/java/pdf/method1/result/RENTAL1.pdf");
		WriteLocal.fileWrite(bytes, file);
	}
}
