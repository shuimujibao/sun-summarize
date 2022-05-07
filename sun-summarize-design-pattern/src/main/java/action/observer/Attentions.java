package action.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Attentions {
    //关注客户列表
    protected List<Observer> observers = new ArrayList<>();

    public void add(Observer observer) {
        observers.add(observer);
    }

    public void remove(Observer observer) {
        observers.add(observer);
    }

    public abstract void notifyObservers();
}
