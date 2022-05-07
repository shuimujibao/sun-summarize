package structure.facade;

public class CustomerClient {
    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();
        orderFacade.doOther();
    }
}
