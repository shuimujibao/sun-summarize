package pdf.method3.fill;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfStamper;

import java.util.Map;

/**
 * 文字内容填充
 *
 * @summary WriteWordFill
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月30日 14:08:00
 */
public class WriteWordFill implements Fill {

	@Override
	public void action(Map<String, Object> dataSource, PdfStamper stamper) {
		try {
			// 获取pdf表单
			AcroFields form = stamper.getAcroFields();

			// 字体设置
			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			form.addSubstitutionFont(bf);

			// 填充文本内容
			for (String key : dataSource.keySet()) {
				Object o = dataSource.get(key);
				if (o instanceof String) {
					String value = (String) dataSource.get(key);
					form.setField(key, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
