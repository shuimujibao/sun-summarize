package create.singleton;

public class SessionCountClient {
    public static void main(String[] args) {
        Test b = new Test();

        boolean m = b instanceof Test;
        System.out.println(m);
//        SessionCount count = SessionCount.getInstance();
//        count.plus();
//        count.showMessage();
//
//        count.plus();
//        count.showMessage();
//
//        count.decrease();
//        count.showMessage();
    }
}
