package zijie.third.design;

import java.io.File;

/**
 * @author sunxiaoyu3
 * @description 网络获取数据
 * @createTime 2021/01/27 11:07:00
 */
public class DataNetInput implements DataOrigin {
    @Override
    public String getData(File file) {
        return "网络获取数据成功.";
    }
}
