package facade;

import abstract_farctory.menuItem;
import strategy.discount.applydiscount;
import strategy.payment.payment;
import decorator.*;

public class RestaurantFacade {

    private MenuManager menuManager;
    private OrderManager orderManager;
    private PaymentManager paymentManager;

    public RestaurantFacade() {
        this.menuManager = new MenuManager();
        this.orderManager = new OrderManager();
        this.paymentManager = new PaymentManager();
    }

    public void showMenu(String category) {
        menuManager.displayMenu(category);
    }

    public menuItem selectMenuItem(String category, String itemName) {
        return menuManager.createMenuItem(category, itemName);
    }

    public payment choosePayment() {
        return paymentManager.choosePaymentMethod();
    }

    public void placeOrder(menuItem item, boolean addCheese, boolean addSauce, boolean addToppings,
            applydiscount discountStrategy, payment paymentMethod, boolean isDelivery) {

    
         item = orderManager.prepareOrder(item, addCheese, addSauce, addToppings);

        
        double originalPrice = item.getPrice();
        double finalPrice = discountStrategy.apply(originalPrice);

        System.out.println("Original price: " + originalPrice);
        System.out.println("Price after discount: " + finalPrice);

        
        paymentManager.processPayment(paymentMethod, finalPrice, null);

        
        template.OrderTemplate orderTemplate = isDelivery ? new template.DeliveryOrder() : new template.DineInOrder();
        orderTemplate.processOrder(item, finalPrice);
    }
}
