package structure.proxy;

import designpatterns.service.OrderService;

public class ProxyClient {
    public static void main(String[] args) {
        saveOrder();
    }

    private static void saveOrder() {
        //本地代理类
        OrderService orderService = new ProxyOrder();
        orderService.saveOrder();
    }
}
