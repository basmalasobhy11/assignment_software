import facade.RestaurantFacade;
import strategy.discount.*;
import strategy.payment.*;
import java.util.Scanner;

import abstract_farctory.menuItem;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RestaurantFacade restaurant = new RestaurantFacade();

        System.out.println("===== WELCOME TO THE RESTAURANT =====");

        // 1. Choose category
        System.out.println("Available categories: Veg, Non-Veg, Kids");
        System.out.print("Enter category: ");
        String category = sc.nextLine().trim();
        restaurant.DisplayMenu(category);

        // 2. Choose item
        System.out.print("Enter the item name you want to order: ");
        String itemName = sc.nextLine().trim();
        menuItem item = restaurant.createMenuItem(category, itemName);

        // 3. Add-ons
        System.out.print("Add extra cheese? (yes/no): ");
        boolean addCheese = sc.nextLine().trim().equalsIgnoreCase("yes");

        System.out.print("Add extra sauce? (yes/no): ");
        boolean addSauce = sc.nextLine().trim().equalsIgnoreCase("yes");

        System.out.print("Add extra toppings? (yes/no): ");
        boolean addToppings = sc.nextLine().trim().equalsIgnoreCase("yes");

        // 4. Order type
        System.out.print("Order type (dine-in/delivery): ");
        boolean isDelivery = sc.nextLine().trim().equalsIgnoreCase("delivery");

        // 5. Discount selection
        System.out.println("Available discounts"+ category);
        System.out.print("Choose a discount type: ");
        String discountChoice = sc.nextLine().trim();
        applydiscount discountStrategy = null;
        switch (discountChoice.toLowerCase()) {
            case "pizza":
                discountStrategy = new pizzaDis();
                break;
            case "chicken":
                discountStrategy = new chickenDis();
                break;
            case "meat":
                discountStrategy = new meatdis();
                break;

        }

        // 6. Payment selection
        System.out.println("Payment methods: Cash, CreditCard, MobileWallet");
        System.out.print("Choose payment method: ");
        String paymentChoice = sc.nextLine().trim();
        payment paymentMethod;
        switch (paymentChoice.toLowerCase()) {
            case "cash":
                paymentMethod = new Cash();
                break;
            case "creditcard":
                paymentMethod = new credit();
                break;
            case "mobilewallet":
                paymentMethod = new MobileWallets();
                break;
            default:
                paymentMethod = new Cash(); 
                break;
        }

        // 7. Place order
        restaurant.placeOrder(item, addCheese, addSauce, addToppings,
                isDelivery, paymentMethod, discountStrategy);

        System.out.println("Thank you for your order!");
        sc.close();
    }
}