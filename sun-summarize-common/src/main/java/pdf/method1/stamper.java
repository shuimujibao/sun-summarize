//package pdf.method1;
//
//import java.io.File;
//
///**
// * stamper
// *
// * @summary stamper
// * @author: sunxiaoyu016
// * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
// * @since: 2022年07月30日 16:04:00
// */
//public class stamper {
//	// 利用模板生成pdf
//	public static File pdfout(ParamVO paramVO, List<OrderPdfVO> orderPdfVOList, String pdfFileName, Integer num) {
//		// 模板路径
//		String templatePath = SimApiPdfTemplete + File.separator + "sim_shb.pdf";
//		// 生成的新文件路径
//		String newPDFPath = SimApiPdfUploadPath + File.separator + pdfFileName;
//		PdfReader reader;
//		FileOutputStream out;
//		ByteArrayOutputStream bos;
//		PdfStamper stamper;
//		try {
//			//给表单添加中文字体 这里采用系统字体。不设置的话，中文可能无法显示
//			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", false);
//			Font FontChinese = new Font(bf, 5, Font.NORMAL);
//			// 输出流
//			out = new FileOutputStream(newPDFPath);
//			// 读取pdf模板
//			reader = new PdfReader(templatePath);
//			bos = new ByteArrayOutputStream();
//			stamper = new PdfStamper(reader, bos);
//			AcroFields form = stamper.getAcroFields();
//			Map<String, Object> map = packageMap(paramVO);
//			//遍历第一页表单map数据
//			Map<String, String> dateheadmap = (Map<String, String>) map.get("dateheadmap");
//			// 添加所创建的字体
//			form.addSubstitutionFont(bf);
//			for (String key : dateheadmap.keySet()) {
//				String value = dateheadmap.get(key);
//				form.setField(key, value);
//			}
//			//第一页table数据
//			List<AcroFields.FieldPosition> list = form.getFieldPositions("table");
//			Rectangle rect = list.get(0).position;
//			PdfPTable table = packageTable(rect, orderPdfVOList, 10.0F, num);
//			//获取总行数
//			int totalRow = table.getRows().size();
//			//计算需要分页的总页数
//			int totalpage = caculatePageable(totalRow);
//			Document document = new Document();
//			if (totalpage == 1) {
//				//获table页面
//				PdfContentByte under = stamper.getOverContent(1);
//				//添加table
//				table.writeSelectedRows(0, -1, rect.getLeft(), rect.getTop(), under);
//
//			} else {
//				//目前模板中暂时解决分页方案 （动态增加空白模板填充值初始化给9个空白模板不包含收尾两个）
//				for (int i = 1; i <= totalpage; i++) {
//					document.newPage();
//					PdfContentByte under = stamper.getOverContent(i);
//					if (i == 1) {
//						//第一页显示9+头尾4条
//						table.writeSelectedRows(0, onepagerow, rect.getLeft(), rect.getTop(), under);
//					}
//					//空白模板每页显示22条
//					else {
//						table.writeSelectedRows(onepagerow + towpagerow * (i - 2), onepagerow + towpagerow * (i - 1), 60, 800, under);
//					}
//				}
//			}
//
//			//遍历最后一页map数据
//			Map<String, String> datefootmap = (Map<String, String>) map.get("datefootmap");
//			// 添加所创建的字体
//			form.addSubstitutionFont(bf);
//			for (String key : datefootmap.keySet()) {
//				String value = datefootmap.get(key);
//				form.setField(key, value);
//			}
//			// 如果为false，生成的PDF文件可以编辑，如果为true，生成的PDF文件不可以编辑
//			stamper.setFormFlattening(true);
//			stamper.close();
//			Document doc = new Document();
//			PdfCopy copy = new PdfCopy(doc, out);
//			PdfImportedPage importPage = null;
//			doc.open();
//			copyvalidPage(totalpage, importPage, reader, copy, bos);
//			doc.close();
//			File file = new File(newPDFPath);
//			return file;
//		} catch (IOException e) {
//			System.out.print(e);
//		} catch (DocumentException e) {
//			System.out.print(e);
//		}
//		return null;
//	}
//
//}
