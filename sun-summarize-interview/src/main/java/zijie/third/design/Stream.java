package zijie.third.design;

/**
 * @author sunxiaoyu3
 * @description 数据加密类
 *
 * <p>
 * 数据的输入有两种方式，文件输入和网络输入
 * 数据的加密方式有两种 base64 与 aes
 * 设计这样的一个Stream类 （桥接模式）
 * </p>
 * @createTime 2021/01/27 10:23:00
 */
public class Stream {

    public static void main(String[] args) {
        //获取数据文件
        DataOrigin dataOrigin = new DataFileInput();
        //获取加密方式
        EncryptStyle encryptStyle = new EncryptBase64();
        //文件夹输入至加密逻辑
        encryptStyle.setDataOrigin(dataOrigin);
        //开始加密
        encryptStyle.encrypt();
    }
}
