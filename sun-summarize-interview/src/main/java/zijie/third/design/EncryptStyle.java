package zijie.third.design;

/**
 * @author sunxiaoyu3
 * @description 加密方式 (base64  aes)
 * @createTime 2021/01/27 10:41:00
 */
public abstract class EncryptStyle {
    private DataOrigin dataOrigin;

    void setDataOrigin(DataOrigin dataOrigin) {
        this.dataOrigin = dataOrigin;
    }

    public abstract void encrypt();
}
