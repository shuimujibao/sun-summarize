package pdf.method1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * WriteLocal
 *
 * @summary WriteLocal
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月29日 19:48:00
 */
public class WriteLocal {

	/**
	 * 传入需要写入的文件路径
	 *
	 * @param fileWriteRoad 路径
	 * @param bytes         待写入数据
	 */
	public static void fileWrite(byte[] bytes, File fileWriteRoad) {// 传入需要写入的文件路径
		try {
			// 通过传入fileWriteRoad文件路径创建一个输出流对象
			FileOutputStream writeFile = new FileOutputStream(fileWriteRoad);
			// 将读到的内容写入文件writeFile中
			writeFile.write(bytes);
			writeFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
