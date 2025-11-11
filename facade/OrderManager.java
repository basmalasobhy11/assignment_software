package facade;

import abstract_farctory.menuItem;
import decorator.*;
import observer.*;

public class OrderManager {
    private notifier orderNotifier;

    public OrderManager() {
        this.orderNotifier = new order();
        this.orderNotifier.registerObserver(new Kitchen());
        this.orderNotifier.registerObserver(new waiter());
    }

    public void prepareOrder(menuItem item, boolean addCheese, boolean addSause, boolean addToppings) {
        if (addCheese) item = new ExtraCheese(item);
        if (addSause) item = new ExtraSause(item);
        if (addToppings) item = new toppings(item);

        orderNotifier.notifyObservers("New order placed: " + item.getName() + " | Price: " + item.getPrice());
    }
}
