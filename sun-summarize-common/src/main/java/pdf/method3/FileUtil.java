package pdf.method3;

import java.io.*;

/**
 * io操作
 *
 * @summary FileUtil
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月30日 14:48:00
 */
public class FileUtil {

	/**
	 * 获取输入流
	 *
	 * @param path 路径
	 * @return InputStream
	 */
	public static InputStream getInput(String path) throws FileNotFoundException {
		return new FileInputStream(path);
	}

	/**
	 * 获取输出流
	 *
	 * @param path 路径
	 * @return FileOutputStream
	 */
	public static FileOutputStream getOutput(String path) throws FileNotFoundException {
		File file = new File(path);
		return new FileOutputStream(file);
	}
}
