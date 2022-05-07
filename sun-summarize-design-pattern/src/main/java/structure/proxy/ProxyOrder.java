package structure.proxy;

import designpatterns.service.OrderService;
import designpatterns.service.impl.OutOrderServiceImpl;

public class ProxyOrder implements OrderService {
    //真实的订单服务
    private OrderService orderService = new OutOrderServiceImpl();

    @Override
    public int saveOrder() {
        System.out.println("开始海外下订单");
        return orderService.saveOrder();
    }
}
