package action.observer;

/**
 * @author : itw_sunxy
 * @title 设计模式之观察者模式
 * @description
 * @createtime : 2019/7/2 19:48
 */
public class ObserverClient {
    public static void main(String[] args) {
        MangoAttention attention = new MangoAttention();
        attention.add(new CustomerObserver("deer"));
        attention.add(new CustomerObserver("james"));
        attention.add(new CustomerObserver("lison"));
        attention.add(new CustomerObserver("mark"));

        attention.perform();
    }
}
