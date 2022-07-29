package pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * CreatePdf
 *
 * @summary CreatePdf
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月29日 13:44:00
 */
public class CreatePdf {

	public static void main(String[] args) throws FileNotFoundException, DocumentException {

		// 新建文档对象
		Document document = new Document();

		// PDF输出位置
		FileOutputStream fileOutputStream = new FileOutputStream("/Users/tal/test.pdf");

		// 创建PdfWrite对象
		PdfWriter.getInstance(document, fileOutputStream);

		// 打开文档
		document.open();

		// 添加内容段落
		Paragraph elements = new Paragraph("Hello,world");
		document.add(elements);

		// 关闭文档
		document.close();
	}
}
