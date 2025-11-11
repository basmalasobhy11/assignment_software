package facade;

import abstract_farctory.menuItem;
import strategy.discount.applydiscount;
import strategy.payment.payment;

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
                           applydiscount discountStrategy, payment paymentMethod) {

        // 1. Prepare order (with add-ons)
        orderManager.prepareOrder(item, addCheese, addSauce, addToppings);

        // 2. Calculate price with discount
        double originalPrice = item.getPrice();
        double finalPrice = discountStrategy.apply(originalPrice);

        System.out.println("Original price: " + originalPrice);
        System.out.println("Price after discount: " + finalPrice);

        // 3. Process payment
        paymentManager.processPayment(paymentMethod, finalPrice, null);
    }
}
