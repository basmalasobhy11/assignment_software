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

       
        String category = "";
        while (category.isEmpty()) {
            System.out.println("Available categories: Veg, Non-Veg, Kids");
            System.out.print("Enter category: ");
            category = sc.nextLine().trim();
            if (category.isEmpty()) {
                System.out.println("Please enter a valid category.");
            }
        }

        restaurant.showMenu(category);

        
        menuItem item = null;
        while (item == null) {
            System.out.print("Enter the item name you want to order: ");
            String itemName = sc.nextLine().trim();
            item = restaurant.selectMenuItem(category, itemName);
            if (item == null) {
                System.out.println("Invalid item. Please select a valid menu item.");
            }
        }

        
        System.out.print("Add extra cheese? (yes/no): ");
        boolean addCheese = sc.nextLine().trim().equalsIgnoreCase("yes");

        System.out.print("Add extra sauce? (yes/no): ");
        boolean addSauce = sc.nextLine().trim().equalsIgnoreCase("yes");

        System.out.print("Add extra toppings? (yes/no): ");
        boolean addToppings = sc.nextLine().trim().equalsIgnoreCase("yes");

        
        System.out.print("Order type (dine-in/delivery): ");
        boolean isDelivery = sc.nextLine().trim().equalsIgnoreCase("delivery");

        
        applydiscount discountStrategy = null;
        while (discountStrategy == null) {
            System.out.println("Available discounts: pizza, chicken, meat");
            System.out.print("Choose a discount type: ");
            String discountChoice = sc.nextLine().trim().toLowerCase();

            switch (discountChoice) {
                case "pizza": discountStrategy = new pizzaDis(); break;
                case "chicken": discountStrategy = new chickenDis(); break;
                case "meat": discountStrategy = new meatdis(); break;
                default:
                    System.out.println("Invalid discount type! Choose pizza, chicken, or meat.\n");
            }
        }

        
        payment paymentMethod = null;
        while (paymentMethod == null) {
            paymentMethod = restaurant.choosePayment(); 
        }

        
    restaurant.placeOrder(item, addCheese, addSauce, addToppings, discountStrategy, paymentMethod, isDelivery);

        System.out.println("\nThank you for your order!");
        sc.close();
    }
}
