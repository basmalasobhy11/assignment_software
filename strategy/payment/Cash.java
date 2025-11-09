package strategy.payment;

public class Cash implements payment{
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Cash.");
    }
}
