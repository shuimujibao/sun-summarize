package pdf.method1;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GenerateChinesePDF
 *
 * @summary GenerateChinesePDF
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月29日 19:29:00
 */
public class GenerateChinesePDF {

	public static final Map<String, String> data = new HashMap<>();

	static {
		data.put("1", "sun");
	}

	/**
	 * 基于模板生成PDF
	 *
	 * @param template 模板
	 * @return 生成后的pdf
	 */

	static byte[] generateChinesePDF(byte[] template) {
		ByteArrayOutputStream bos = null;
		try {
			PdfReader reader = new PdfReader(template);
			bos = new ByteArrayOutputStream();
			// 将要生成的目标PDF文件名称
			PdfStamper ps = new PdfStamper(reader, bos);

			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			ArrayList<BaseFont> fontList = new ArrayList<>();
			fontList.add(bf);
			/// 取出报表模板中的所有字段
			AcroFields fields = ps.getAcroFields();
			fields.setGenerateAppearances(true);
			fields.setSubstitutionFonts(fontList);
			fillData(fields, data);
			// 必须要调用这个，否则文档不会生成的  如果为false那么生成的PDF文件还能编辑，一定要设为true
			ps.setFormFlattening(true);
			ps.close();
			return bos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/**
	 * pdf中的数据填充
	 *
	 * @param fields 域
	 * @param data 数据
	 * @throws IOException io异常
	 * @throws DocumentException 文件异常
	 */
	private static void fillData(AcroFields fields, Map<String, String> data) throws IOException, DocumentException {
		List<String> keys = new ArrayList<String>();
		Map<String, AcroFields.Item> formFields = fields.getFields();
		for (String key : data.keySet()) {
			if (formFields.containsKey(key)) {
				String value = data.get(key);
				fields.setField(key, value, value, true);
				keys.add(key);
			}
		}

		for (String itemKey : formFields.keySet()) {
			if (!keys.contains(itemKey)) {
				fields.setField(itemKey, " ");

			}
		}
	}
}
