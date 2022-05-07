package action.observer.jdk;

public class jdkObserverClient {
    public static void main(String[] args) {
        Mango attentions = new Mango("芒果");

        attentions.addObserver(new Customer("deer"));
        attentions.addObserver(new Customer("jack"));
        attentions.addObserver(new Customer("lames"));
        attentions.addObserver(new Customer("linda"));
        attentions.perform();
    }
}
