package pdf.method4;

import com.itextpdf.text.pdf.BaseFont;
import com.lowagie.text.DocumentException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jl.qiao(jl.qiao @ zuche.com)
 * @version 1.0
 */
public class JavaToPdfHtmlFreeMarker {
    private static final String DEST = "template.pdf";
//        ClassLoader.getSystemClassLoader().getResource("template/template.pdf").getPath();
//    private static final String HTML = ClassLoader.getSystemClassLoader().getResource("template/template.html").getPath();
//    private static final String FONT = ClassLoader.getSystemClassLoader().getResource("template/simhei.ttf").getPath();
private static final String HTML = "template.html";
	private static final String FONT = "simhei.ttf";
    private static final String FILE_PATH = "file://"+ClassLoader.getSystemClassLoader().getResource("template").getPath();

    private static Configuration freemarkerCfg = null;

    static {
        freemarkerCfg =new Configuration();
        //freemarker的模板目录
        try {
            freemarkerCfg.setDirectoryForTemplateLoading(new File(ClassLoader.getSystemClassLoader().getResource("template").getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, DocumentException, com.lowagie.text.DocumentException {
        Map<String,Object> data = buildData();
        String content = JavaToPdfHtmlFreeMarker.freeMarkerRender(data,HTML);
        JavaToPdfHtmlFreeMarker.createPdf(content,DEST);
    }

    private static Map<String, Object> buildData(){
        Map<String, Object> map = new HashMap<>();
        map.put("no", "123456789");
        map.put("name", "张三");
        map.put("date", "2020-11-13");
        map.put("fee", "55.20");
        map.put("filePath", FILE_PATH);
        List<Map<String, Object>> detailList = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("vehicleNo", "京A1234");
        map1.put("shortModel", "小型汽车");
        map1.put("inDate", "2020-11-13 00：10:22");
        map1.put("inName", "北京");
        map1.put("outDate", "2020-11-14 00：10:22");
        map1.put("outName", "天津");
        map1.put("fee", "10.00");
        detailList.add(map1);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("vehicleNo", "京A1234");
        map2.put("shortModel", "大型汽车");
        map2.put("inDate", "2020-11-13 00：10:22");
        map2.put("inName", "北京");
        map2.put("outDate", "2020-11-14 00：10:22");
        map2.put("outName", "天津");
        map2.put("fee", "20.00");
        detailList.add(map2);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("vehicleNo", "京E1234");
        map3.put("shortModel", "大型汽车");
        map3.put("inDate", "2020-11-13 00：10:22");
        map3.put("inName", "北京");
        map3.put("outDate", "2020-11-14 00：10:22");
        map3.put("outName", "天津11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        map3.put("fee", "2.00");
        detailList.add(map3);
        map.put("detailList", detailList);
        return map;
    }
    /**
     * freemarker渲染html
     */
    public static String freeMarkerRender(Map<String, Object> data, String htmlTmp) {
        Writer out = new StringWriter();
        try {
            // 获取模板,并设置编码方式
            Template template = freemarkerCfg.getTemplate(htmlTmp);
            template.setEncoding("UTF-8");
            // 合并数据模型与模板
            template.process(data, out); //将合并后的数据和模板写入到流中，这里使用的字符流
            out.flush();
            return out.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public static void createPdf(String content,String dest) throws IOException, DocumentException, com.lowagie.text.DocumentException {
        ITextRenderer render = new ITextRenderer();
        SharedContext sharedContext = render.getSharedContext();
        sharedContext.setBaseURL(FILE_PATH);
        ITextFontResolver fontResolver = render.getFontResolver();
        fontResolver.addFont(FONT, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        // 解析html生成pdf
        render.setDocumentFromString(content);
        render.layout();
        render.createPDF(new FileOutputStream(dest));
    }

}
