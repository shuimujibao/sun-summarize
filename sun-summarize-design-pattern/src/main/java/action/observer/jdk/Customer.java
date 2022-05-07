package action.observer.jdk;

import java.util.Observable;

public class Customer extends Observable {
    String name;

    Customer(String name) {
        this.name = name;
    }

}
