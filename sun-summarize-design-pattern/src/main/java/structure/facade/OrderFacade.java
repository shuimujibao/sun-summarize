package structure.facade;

public class OrderFacade {
    PackService packService;
    PickService pickService;
    SendService sendService;

    OrderFacade() {
        packService = new PackService();
        pickService = new PickService();
        sendService = new SendService();
    }

    public void doOther() {
        pickService.doPick();
        packService.doPack();
        sendService.doSend();
    }
}
