package pdf.method3.fill;

import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;

import java.util.List;
import java.util.Map;

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

	private static final String key = "eventList";

	@Override
	public void action(Map<String, Object> data, PdfStamper stamper) {
		try {
			// 获取表单
			AcroFields form = stamper.getAcroFields();

			// 字体设置
			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);

			// 获取待填充数据
			Map<String, List<List<String>>> listMap = (Map<String, List<List<String>>>) data.get("list");

			// 表格总条数
			List<List<String>> lists = listMap.get(key);
			int pageNo = form.getFieldPositions(key).get(0).page;
			PdfContentByte pcb = stamper.getOverContent(pageNo);
			Rectangle signRect = form.getFieldPositions(key).get(0).position;

			// 获取表格行列，构建表格
			int column = lists.get(0).size();
			int row = lists.size();
			PdfPTable table = new PdfPTable(column);

			// 样式设置
			float totalWidth = signRect.getRight() - signRect.getLeft() - 1;
			int size = lists.get(0).size();
			float[] width = new float[size];
			for (int i = 0; i < size; i++) {
				if (i == 0) {
					width[i] = 60f;
				} else {
					width[i] = (totalWidth - 60) / (size - 1);
				}
			}
			table.setTotalWidth(width);
			table.setLockedWidth(true);
			table.setKeepTogether(true);
			table.setSplitLate(false);
			table.setSplitRows(true);
			Font FontProve = new Font(bf, 10, 0);

			// 表格数据填写
			for (List<String> list : lists) {
				for (int j = 0; j < column; j++) {
					Paragraph paragraph = new Paragraph(String.valueOf(list.get(j)), FontProve);
					PdfPCell cell = new PdfPCell(paragraph);
					cell.setBorderWidth(1);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setLeading(0, (float) 1.4);
					table.addCell(cell);
				}
			}
			table.writeSelectedRows(0, -1, signRect.getLeft(), signRect.getTop(), pcb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
