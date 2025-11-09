package strategy.payment;

public class credit implements payment{
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using credit.");
    }
}
