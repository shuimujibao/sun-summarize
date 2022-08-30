package pdf.method3.fill;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import org.omg.CORBA.StringSeqHelper;
import pdf.method3.OrderPdfVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 表格内容填充
 *
 * @summary TableFill
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月30日 14:10:00
 */
@SuppressWarnings("unchecked")
public class TableFill implements Fill {

	/**
	 * 表格域
	 */
	private static final String KEY = "eventList";

	/**
	 * 第一页行数
	 */
	private static final int ONE_PAGE_ROW = 10;

	/**
	 * 空白页行数
	 */
	private static final int TOW_PAGE_ROW = 15;

	private static List<OrderPdfVO> orderPdfVOList = new ArrayList<>();

	static {
		OrderPdfVO orderPdfVO = new OrderPdfVO();

		orderPdfVO.setCol1("序号");
		orderPdfVO.setCol2("车牌号");
		orderPdfVO.setCol3("入站时间");
		orderPdfVO.setCol4("入口站名");
		orderPdfVO.setCol5("出站时间");
		orderPdfVO.setCol6("出口站名");
		orderPdfVO.setCol7("费用里程");
		orderPdfVO.setCol8("金额");
		orderPdfVOList.add(orderPdfVO);

		for (int i = 0; i < 30; i++) {
			orderPdfVO = new OrderPdfVO();
			orderPdfVO.setCol1(i + 1 + "");
			orderPdfVO.setCol2("333" + Math.random());
			orderPdfVO.setCol3("333" + Math.random());
			orderPdfVO.setCol4("333" + Math.random());
			orderPdfVO.setCol5("333" + Math.random());
			orderPdfVO.setCol6("333" + Math.random());
			orderPdfVO.setCol7("333" + Math.random());
			orderPdfVO.setCol8(StringSeqHelper.id());
			orderPdfVOList.add(orderPdfVO);
		}

	}

	@Override
	public void action(Map<String, Object> data, PdfStamper stamper) {
		try {
			// 获取表单
			AcroFields form = stamper.getAcroFields();

			// 获取待填充数据
			Map<String, List<List<String>>> listMap = (Map<String, List<List<String>>>) data.get("list");

			// 表格总条数
			List<List<String>> lists = listMap.get(KEY);

			// 获取模板中表格信息
			int pageNo = form.getFieldPositions(KEY).get(0).page;
			Rectangle rect = form.getFieldPositions(KEY).get(0).position;

			PdfPTable table = packageTable(rect, orderPdfVOList, 10.0F);

			//获取总行数
			int totalRow = table.getRows().size();

			// 计算需要分页的总页数
			int totalpage = calculatedPageable(totalRow);

			Document document = new Document();
			if (totalpage == 1) {
				//获table页面
				PdfContentByte under = stamper.getOverContent(1);
				//添加table
				table.writeSelectedRows(0, -1, rect.getLeft(), rect.getTop(), under);

			} else {
				// 目前模板中暂时解决分页方案 （动态增加空白模板填充值初始化给9个空白模板不包含收尾两个）
				for (int i = 1; i <= totalpage; i++) {
					document.newPage();
					PdfContentByte under = stamper.getOverContent(i);
					if (Objects.isNull(under)) {
						return;
					}
					if (i == 1) {
						//第一页显示9+头尾4条
						table.writeSelectedRows(0, ONE_PAGE_ROW, rect.getLeft(), rect.getTop(), under);
					}
					//空白模板每页显示22条
					else {
						table.writeSelectedRows(ONE_PAGE_ROW + TOW_PAGE_ROW * (i - 2), ONE_PAGE_ROW + TOW_PAGE_ROW * (i - 1), rect.getLeft(), rect.getTop() + 300, under);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 组装pdf 中的table 包括样式字体
	 */
	public static PdfPTable packageTable(Rectangle rect, List<OrderPdfVO> list, Float fontSize) {
		try {
			// 创建table下面通过table.addCell添加的时候必须添加整行内容的所有列
			PdfPTable table = new PdfPTable(8);
			table.setWidthPercentage(100.0F);
			BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", false);
			Font fontZH = new Font(bfChinese, fontSize == null ? 12F : fontSize, 0);
			// 第一行是列表名
			table.setHeaderRows(1);
			table.getDefaultCell().setHorizontalAlignment(1);
			float tatalWidth = rect.getRight() - rect.getLeft() - 1;
			// 计算表格宽度
			float[] columnWidth = {(float) (tatalWidth * 0.1),
				(float) (tatalWidth * 0.2), (float) (tatalWidth * 0.2),
				(float) (tatalWidth * 0.1), (float) (tatalWidth * 0.1),
				(float) (tatalWidth * 0.1), (float) (tatalWidth * 0.1),
				(float) (tatalWidth * 0.1)};
			table.setTotalWidth(columnWidth);
			table.setLockedWidth(true);
			//遍历List 获取每一列的数据，填充到pdfTable中
			list.forEach(orderPdfVO -> {
				table.addCell(createCell(orderPdfVO.getCol1(), fontZH));
				table.addCell(createCell(orderPdfVO.getCol2(), fontZH));
				table.addCell(createCell(orderPdfVO.getCol3(), fontZH));
				table.addCell(createCell(orderPdfVO.getCol4(), fontZH));
				table.addCell(createCell(orderPdfVO.getCol5(), fontZH));
				table.addCell(createCell(orderPdfVO.getCol6(), fontZH));
				table.addCell(createCell(orderPdfVO.getCol7(), fontZH));
				table.addCell(createCell(orderPdfVO.getCol8(), fontZH));
			});
			//cell跨页
			table.setKeepTogether(true);
			table.setSplitLate(false);
			table.setSplitRows(true);
			return table;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 创建表格
	 *
	 * @param value
	 * @param fontZH
	 * @return
	 */
	private static PdfPCell createCell(String value, Font fontZH) {
		PdfPCell cell = new PdfPCell();
		cell.setPhrase(new Phrase(value, fontZH));
//		 cell.setBorder(Rectangle.IMGRAW);
		return cell;
	}


	/**
	 * 计算分页
	 */
	public static int calculatedPageable(int totalRow) {
		int totalPage = 1;
		int page = (totalRow - ONE_PAGE_ROW) % TOW_PAGE_ROW == 0 ? (totalRow - ONE_PAGE_ROW) / TOW_PAGE_ROW + 1 : (totalRow - ONE_PAGE_ROW) / TOW_PAGE_ROW + 2;
		return totalRow < ONE_PAGE_ROW ? totalPage : page;

	}

	public static void main(String[] args) {
		System.out.println(calculatedPageable(100));
	}
}
