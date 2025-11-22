package template;

import abstract_farctory.menuItem;
import observer.order;
import observer.Kitchen;
import observer.waiter;

public abstract class OrderTemplate {

    public final void processOrder(menuItem item, double finalPrice) {
        takeOrder(item);
        prepareOrder(item);
        serveOrDeliver();
        generateBill(item, finalPrice);
    }

    private void takeOrder(menuItem item) {
        System.out.println(" Taking order for: " + item.getName());
    }

    private void prepareOrder(menuItem item) {
        order notifier = new order();
        Kitchen kitchen = new Kitchen();
        waiter waiter = new waiter();
        notifier.registerObserver(kitchen);
        notifier.registerObserver(waiter);
        notifier.notifyObservers(item.getName());
        System.out.println(" Preparing: " + item.getName());
        
    }

    protected abstract void serveOrDeliver(); 

    private void generateBill(menuItem item, double finalPrice) {
        System.out.println("💰 Total Price: $" + finalPrice);
    }
}

