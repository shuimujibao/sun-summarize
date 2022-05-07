package create.singleton;

import java.util.concurrent.atomic.AtomicInteger;

public class SessionCount {
    private AtomicInteger count = new AtomicInteger();

    //    private static SessionCount instance = new SessionCount();
    //    private SessionCount(){}
    //    public static SessionCount getInstance(){
    //        return instance;
    //    }
    private static SessionCount instance;

    public static SessionCount getInstance() {
        if (instance == null) {
            synchronized (SessionCount.class) {
                if (instance == null) {
                    instance = new SessionCount();
                }
            }
        }
        return instance;
    }

    public int plus() {
        return count.incrementAndGet();
    }

    public int decrease() {
        return count.decrementAndGet();
    }

    public void showMessage() {
        System.out.println("当前人数：" + this.count.get());
    }
}
