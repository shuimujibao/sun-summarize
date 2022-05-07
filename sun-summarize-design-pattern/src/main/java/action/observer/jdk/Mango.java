package action.observer.jdk;

import java.util.Observable;

public class Mango extends Observable {
    private String name;

    public Mango(String name) {
        this.name = name;
    }

    public void perform() {
        this.setChanged();
        this.notifyObservers();
    }

    public void addObserver(Customer customer) {
        System.out.println(customer.name + "购买" + name);
    }
}
