package pdf.method3;

import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import pdf.method3.fill.Fill;
import pdf.method3.fill.TableFill;
import pdf.method3.fill.WriteWordFill;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Map;

/**
 * CreateETCPdf
 *
 * @summary CreateETCPdf
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月30日 14:24:00
 */
public class CreateETCPdf {

	/**
	 * 输出资源路径
	 */
	private static final String OUT_PUT = "/Users/tal/IdeaProjects/workspace/sun-summarize/sun-summarize-common/src/main/java/pdf/method3/result/RENTAL1.pdf";

	/**
	 * 获取资源路径
	 */
	private static final String IN_PUT = "/Users/tal/IdeaProjects/workspace/sun-summarize/sun-summarize-common/src/main/java/pdf/method3/model/ETC_TEMPLATE.pdf";


	public static void create(Map<String, Object> dataSource) {
		try {
			// 获取PDF输出位置
			FileOutputStream output = FileUtil.getOutput(OUT_PUT);

			// 获取PDF模板
			InputStream input = FileUtil.getInput(IN_PUT);

			// 获取PDF操作类
			PdfReader reader = new PdfReader(input);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			PdfStamper stamper = new PdfStamper(reader, bos);
			stamper.setFormFlattening(true);

			// 文字内容填充
			Fill writeWordFill = new WriteWordFill();
			writeWordFill.action(dataSource, stamper);

			// 表格内容填充
			stamper.insertPage(5, reader.getPageSizeWithRotation(1));

			Fill tableFill = new TableFill();
			tableFill.action(dataSource, stamper);

			// PDF设置不可编辑，关闭修改操作
			stamper.setFormFlattening(true);
			stamper.close();

			// 将生成后的PDF输出至指定位置
			Document doc = new Document();
			PdfCopy copy = new PdfCopy(doc, output);
			doc.open();
			int pageNum = reader.getNumberOfPages();
			for (int i = 1; i <= pageNum; i++) {
				PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), i);
				copy.addPage(importPage);
			}
			doc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
