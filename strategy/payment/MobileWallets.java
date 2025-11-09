package strategy.payment;

public class MobileWallets implements payment{
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Mobile Wallets.");
    }
}
