package facade;

import java.util.Scanner;

import abstract_farctory.menuItem;
import decorator.ExtraCheese;
import decorator.ExtraSause;
import decorator.toppings;
import strategy.discount.applydiscount;
import strategy.payment.*;

public class PaymentManager {

    // Method to let the user choose the payment method
    public payment choosePaymentMethod() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPayment methods: Cash, CreditCard, MobileWallet");
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
                System.out.println("Unknown payment method. Defaulting to Cash.");
                paymentMethod = new Cash();
                break;
        }

        return paymentMethod;
    }


    public void processPayment(payment paymentMethod, double amount, applydiscount discountStrategy) {
    // Apply discount if a strategy is provided
    double discountedAmount = amount;
    if (discountStrategy != null) {
        discountedAmount = discountStrategy.apply(amount); // apply expects a double
    }

    // Process the payment
    paymentMethod.pay(discountedAmount);
}

}
