package pdf;

import com.itextpdf.text.DocumentException;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 测试生成PDF
 *
 * @summary Test
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月29日 15:15:00
 */
public class Test {

	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		// 表格内容列表
		List<TableContent> tableContentList = new ArrayList<>();

		TableContent tableContent;
		for (int i = 0; i < 10; i++) {
			tableContent = new TableContent();
			double nextDouble = new Random().nextDouble();
			int i1 = new Random().nextInt();

			tableContent.setAmount(new BigDecimal(nextDouble));
			tableContent.setCarNumber("辽A" + i1);
			tableContent.setCarType("高级");
			tableContent.setDistance(i);
			tableContent.setNumber(i + i1);
			tableContent.setComeName("撒");
			tableContent.setComeTime(new Date());
			tableContent.setGoName("哈哈");
			tableContent.setGoTime(new Date());

			tableContentList.add(tableContent);
		}

		// 主信息
		Itinerary itinerary = new Itinerary();
		itinerary.setAmount(new BigDecimal("12"));
		itinerary.setApplyTime(new Date());
		itinerary.setOrderNo(121313);
		itinerary.setRentName("张三");
		itinerary.setTableContentList(tableContentList);

		// 生成PDF
		CreatePdf.createPdf(itinerary);
	}
}
