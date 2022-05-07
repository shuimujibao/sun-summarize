package zijie.third.design;

import java.io.File;

/**
 * @author sunxiaoyu3
 * @description 数据获取
 * (文件输入 网络获取)
 * @createTime 2021/01/27 10:45:00
 */
public interface DataOrigin {

    String getData(File file);
}
