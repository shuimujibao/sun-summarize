package pdf.methiod2;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * CreatePdf
 *
 * @summary CreatePdf
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月29日 13:44:00
 */
public class CreatePdf {

	/**
	 * 字体设置
	 */
	private static final Font font = FontFactory.getFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED, 10f, Font.NORMAL, BaseColor.BLACK);


	/**
	 * 生成PDF
	 *
	 * @param itinerary ETC费用行程单
	 * @throws FileNotFoundException io异常
	 * @throws DocumentException     文件异常
	 */
	public static void createPdf(Itinerary itinerary) throws FileNotFoundException, DocumentException {

		// 新建文档对象
		Document document = new Document();

		// PDF输出位置
		FileOutputStream fileOutputStream = new FileOutputStream("/Users/tal/test.pdf");

		// 创建PdfWrite对象
		PdfWriter.getInstance(document, fileOutputStream);

		// 打开文档
		document.open();

		// TODO log图片

		// 添加标题
		Paragraph elements = new Paragraph("神州租车ETC费用行程单", font);
		document.add(elements);

		// TODO 横线

		// 有序列表
		Paragraph elementOrderNo = new Paragraph("订单号:" + itinerary.getOrderNo(), font);
		Paragraph elementRentName = new Paragraph("承租人姓名:" + itinerary.getRentName(), font);
		Paragraph elementApplyTime = new Paragraph("申请时间:" + itinerary.getApplyTime(), font);
		Paragraph elementAmount = new Paragraph("交易金额:" + itinerary.getAmount(), font);

		document.add(elementOrderNo);
		document.add(elementRentName);
		document.add(elementApplyTime);
		document.add(elementAmount);

		// 生成表格
		PdfPTable table = new PdfPTable(9);
		setTableHeader(table);
		replenishTable(itinerary.getTableContentList(), table);
		table.setSpacingBefore(100f);
		document.add(table);
		document.addLanguage("中文");

		// 关闭文档
		document.close();
	}

	/**
	 * 设置表头
	 *
	 * @param table 表格
	 */
	private static void setTableHeader(PdfPTable table) {
		List<String> tableHeaders = new ArrayList<>();
		tableHeaders.add("序号");
		tableHeaders.add("车牌号");
		tableHeaders.add("短租车型");
		tableHeaders.add("入站时间");
		tableHeaders.add("入口站名");
		tableHeaders.add("出站时间");
		tableHeaders.add("出口站名");
		tableHeaders.add("费用里程");
		tableHeaders.add("金额");

		for (String tableHeader : tableHeaders) {
			Paragraph elements = new Paragraph(tableHeader, font);
			PdfPCell cell = new PdfPCell(elements);
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table.addCell(cell);
		}
	}

	/**
	 * 填充表格数据
	 *
	 * @param tableContentList 内容
	 * @param table            表格
	 */
	private static void replenishTable(List<TableContent> tableContentList, PdfPTable table) {
		for (TableContent tableContent : tableContentList) {
			Paragraph element1 = new Paragraph(tableContent.getNumber().toString(), font);
			Paragraph element2 = new Paragraph(tableContent.getCarNumber(), font);
			Paragraph element3 = new Paragraph(tableContent.getCarType(), font);
			Paragraph element4 = new Paragraph(tableContent.getComeTime().toString(), font);
			Paragraph element5 = new Paragraph(tableContent.getComeName(), font);
			Paragraph element6 = new Paragraph(tableContent.getGoTime().toString(), font);
			Paragraph element7 = new Paragraph(tableContent.getGoName(), font);
			Paragraph element8 = new Paragraph(tableContent.getDistance().toString(), font);
			Paragraph element9 = new Paragraph(tableContent.getAmount().toString(), font);
			table.addCell(element1);
			table.addCell(element2);
			table.addCell(element3);
			table.addCell(element4);
			table.addCell(element5);
			table.addCell(element6);
			table.addCell(element7);
			table.addCell(element8);
			table.addCell(element9);
		}
	}
}
