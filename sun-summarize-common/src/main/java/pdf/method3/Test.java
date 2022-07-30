package pdf.method3;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.*;
import java.util.List;
import java.util.*;

/**
 * Test
 *
 * @summary Test
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月30日 13:26:00
 */
public class Test {

	public static final Map<String, String> data = new HashMap<>();

	static {
		data.put("order_id", "121214434");
		data.put("rent_name", "孙晓宇");
		data.put("apply_time", new Date().toString());
		data.put("amount", "11.34");
	}

	public static void main(String[] args) {
		//表格 一行数据是一个list
		List<String> list = new ArrayList<>();
		list.add("序号");
		list.add("车牌号");
		list.add("入站时间");
		list.add("入口站名");
		list.add("出站时间");
		list.add("出口站名");
		list.add("费用里程");
		list.add("金额");

		List<List<String>> List = new ArrayList<>();
		List.add(list);


		for (int i = 0; i < 100; i++) {
			List<String> list2 = new ArrayList<>();
			list2.add("1");
			list2.add("2");
			list2.add("3");
			list2.add("4");
			list2.add("4");
			list2.add("5");
			list2.add("6");
			list2.add("6");
			List.add(list2);
		}


		Map<String, List<List<String>>> listMap = new HashMap<>();
		listMap.put("eventList", List);

		Map<String, Object> o = new HashMap<>();
		o.put("list", listMap);
		o.putAll(data);

//		creatPdf(o);

		CreateETCPdf.create(o);
	}

	public static void creatPdf(Map<String, Object> map) {
		try {
			// 字体设置
			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			File file = new File("/Users/tal/IdeaProjects/workspace/sun-summarize/sun-summarize-common/src/main/java/pdf/method3/result/RENTAL1.pdf");
			// 输出流
			FileOutputStream out = new FileOutputStream(file);
			// 读取pdf模板
			InputStream resourceAsStream = new FileInputStream("/Users/tal/IdeaProjects/workspace/sun-summarize/sun-summarize-common/src/main/java/pdf/method3/model/ETC_TEMPLATE.pdf");
			PdfReader reader = new PdfReader(resourceAsStream);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			PdfStamper stamper = new PdfStamper(reader, bos);
			stamper.setFormFlattening(true);
			AcroFields form = stamper.getAcroFields();
			// 文字类的内容处理
			Map<String, String> datemap = data;
			form.addSubstitutionFont(bf);
			for (String key : datemap.keySet()) {
				String value = datemap.get(key);
				form.setField(key, value);
			}
			// 表格类
			Map<String, List<List<String>>> listMap = (Map<String, List<List<String>>>) map.get("list");
			for (String key : listMap.keySet()) {
				List<List<String>> lists = listMap.get(key);
				int pageNo = form.getFieldPositions(key).get(0).page;
				PdfContentByte pcb = stamper.getOverContent(pageNo);
				Rectangle signRect = form.getFieldPositions(key).get(0).position;
				//表格位置
				int column = lists.get(0).size();
				int row = lists.size();
				PdfPTable table = new PdfPTable(column);
				float tatalWidth = signRect.getRight() - signRect.getLeft() - 1;
				int size = lists.get(0).size();
				float width[] = new float[size];
				for (int i = 0; i < size; i++) {
					if (i == 0) {
						width[i] = 60f;
					} else {
						width[i] = (tatalWidth - 60) / (size - 1);
					}
				}
				table.setTotalWidth(width);
				table.setLockedWidth(true);
				table.setKeepTogether(true);
				table.setSplitLate(false);
				table.setSplitRows(true);
				Font FontProve = new Font(bf, 10, 0);
				//表格数据填写
				for (int i = 0; i < row; i++) {
					List<String> list = lists.get(i);
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
			}
			// 如果为false，生成的PDF文件可以编辑，如果为true，生成的PDF文件不可以编辑
			stamper.setFormFlattening(true);
			stamper.close();
			Document doc = new Document();
			PdfCopy copy = new PdfCopy(doc, out);
			doc.open();
			int pageNum = reader.getNumberOfPages();
			for (int i = 1; i <= pageNum; i++) {
				PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), i);
				copy.addPage(importPage);
			}
			doc.close();
		} catch (IOException e) {
			System.out.println(e);
		} catch (DocumentException e) {
			System.out.println(e);
		}
	}
}
