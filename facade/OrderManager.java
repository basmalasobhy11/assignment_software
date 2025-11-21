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

   public menuItem prepareOrder(menuItem item, boolean addCheese, boolean addSauce, boolean addToppings) {

    menuItem finalItem = item;

    if (addCheese) {
        finalItem = new ExtraCheese(finalItem);
    }
    if (addSauce) {
        finalItem = new ExtraSause(finalItem);
    }
    if (addToppings) {
        finalItem = new toppings(finalItem);
    }

    return finalItem;
}

}
