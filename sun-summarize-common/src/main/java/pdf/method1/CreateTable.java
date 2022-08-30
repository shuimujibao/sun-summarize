package pdf.method1;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.text.DecimalFormat;

/**
 * CreateTable
 *
 * @summary CreateTable
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月30日 10:25:00
 */
public class CreateTable {

	/**
	 * 动态表格生成及模拟数据
	 *
	 * @param document 文件
	 */
	public static void appendTableToDocument(Document document) {

		//定义 6列的表格
		PdfPTable table = new PdfPTable(new float[]{80, 80, 80, 80, 80, 80});
		table.setTotalWidth(520);
		table.setLockedWidth(true);
		table.setHorizontalAlignment(Element.ALIGN_CENTER);//居中

		try {
			//定义数据的字体
			BaseFont baseFont = BaseFont.createFont("Helvetica", "UTF-8", BaseFont.NOT_EMBEDDED);
			Font textFont = new Font(baseFont, 6, Font.NORMAL);

			//表头模拟数据
			for (int i = 0; i < 6; i++) {
				PdfPCell heardCell = new PdfPCell();
				heardCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				heardCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				heardCell.setPhrase(new Phrase("value", textFont));
				table.addCell(heardCell);
			}
			//表格数据
			DecimalFormat df = new DecimalFormat("0.00");
			for (int i = 0; i < 1000; i++) {
				PdfPCell value1 = new PdfPCell();
				value1.setPhrase(new Phrase("2022" + i, textFont));
				table.addCell(value1);
				Double value = Math.random() * 10;
				PdfPCell value2 = new PdfPCell();
				value2.setPhrase(new Phrase(df.format(value), textFont));

			}
			document.add(table);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
