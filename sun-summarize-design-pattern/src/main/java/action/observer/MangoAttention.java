package action.observer;

public class MangoAttention extends Attentions {
    @Override
    public void notifyObservers() {
        for (Observer observer :
                observers) {
            observer.update();
        }
    }

    //芒果到货了
    public void perform() {
        this.notifyObservers();
    }
}
