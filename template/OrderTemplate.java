package template;

import abstract_farctory.menuItem;
import observer.Order;
import observer.Kitchen;
import observer.Waiter;

public abstract class OrderTemplate {

    public final void processOrder(menuItem item) {
        takeOrder(item);
        prepareOrder(item);
        serveOrDeliver();
        generateBill(item);
    }

    private void takeOrder(menuItem item) {
        System.out.println(" Taking order for: " + item.getName());
    }

    private void prepareOrder(menuItem item) {
        System.out.println(" Preparing: " + item.getName());

        // Notify kitchen and waiter using Observer
        Order notifier = new Order();
        Kitchen kitchen = new Kitchen();
        Waiter waiter = new Waiter();
        notifier.registerObserver(kitchen);
        notifier.registerObserver(waiter);
        notifier.notifyObservers(item.getName());
    }

    protected abstract void serveOrDeliver(); // customizable by subclass

    private void generateBill(menuItem item) {
        System.out.println("💰 Total Price: $" + item.getPrice());
    }
}

