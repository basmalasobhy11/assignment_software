
package facade;
import observer.Kitchen;
import observer.waiter;
import observer.order;

import observer.notifier;
import abstract_farctory.menuItem;
import abstract_farctory.BaseMenuItem;
import abstract_farctory.factory_method.*;
import abstract_farctory.factory_method.KidsMenuFactory;
import strategy.payment.payment;
import strategy.discount.applydiscount;
import decorator.ExtraCheese;
import decorator.ExtraSause;
import decorator.toppings;
import template.*;
import java.util.List;
import java.util.ArrayList;
public class RestaurantFacade {
    private MenuItemFactory vegFactory;
    private MenuItemFactory noVegFactory;
    private MenuItemFactory kidsFactory;

    private notifier orderNotifier;

    public RestaurantFacade() {

        
        this.vegFactory = new VegMenuFactory();
        this.noVegFactory = new NoVegMenuFactory();
        this.kidsFactory = new KidsMenuFactory();

        this.orderNotifier = new order();
        this.orderNotifier.registerObserver(new Kitchen());

        this.orderNotifier.registerObserver(new waiter());
    }
    public void DisplayMenu(String category) {
        List<BaseMenuItem> menuItems = new ArrayList<>();
        switch (category.toLowerCase()) {
            case "veg":
                menuItems.add(vegFactory.createMenuItem("Italian pizza"));
                menuItems.add(vegFactory.createMenuItem("Eastern Pizza"));
            
                break;
            case "non-veg":
                menuItems.add(noVegFactory.createMenuItem("Chicken Pizza"));
                menuItems.add(noVegFactory.createMenuItem("Chicken Shawarma"));
                break;
            case "kids":
                menuItems.add(kidsFactory.createMenuItem("Kids Meal"));
                menuItems.add(kidsFactory.createMenuItem("Checkin nuggets"));
                menuItems.add(kidsFactory.createMenuItem("Mini burger"));
                break;
            default:
                System.out.println("Unknown menu category: " + category);
                return;
        }
        System.out.println("---- " + category.toUpperCase() + " MENU ----");
        for (BaseMenuItem item : menuItems) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
    }

    public BaseMenuItem createMenuItem(String category, String type) {
        switch (category.toLowerCase()) {
            case "veg":
                return vegFactory.createMenuItem(type);
            case "non-veg":
                return noVegFactory.createMenuItem(type);
            case "kids":
                return kidsFactory.createMenuItem(type);
            default:
                throw new IllegalArgumentException(" Unknown menu category: " + category);
        }
    }
    public void placeOrder(menuItem item,boolean addCheese, boolean addSause,boolean addToppings,
    boolean isDelivery, 
    payment paymentStrategy, applydiscount discountStrategy) {
       
        if (addCheese){
            item=new ExtraCheese(item);
        }
        if (addSause){
            item=new ExtraSause(item);
        }
        if (addToppings){
            item=new toppings(item);
        }
        OrderTemplate OrderWorkFlow;
        if (isDelivery) {
            OrderWorkFlow = new DeliveryOrder();
        } else {
            OrderWorkFlow = new DineInOrder();
        }
    

        OrderWorkFlow.processOrder(item);
        double discountedPrice = discountStrategy.apply(item.getPrice());
         System.out.println("price after discount: $" + discountedPrice);
        paymentStrategy.pay(discountedPrice);

    }
};