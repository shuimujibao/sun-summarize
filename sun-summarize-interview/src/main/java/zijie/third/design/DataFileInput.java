package zijie.third.design;

import java.io.File;

/**
 * @author sunxiaoyu3
 * @description 文件读取数据
 * @createTime 2021/01/27 11:06:00
 */
public class DataFileInput implements DataOrigin{
    @Override
    public String getData(File file) {
        return "文件读取数据成功.";
    }
}
