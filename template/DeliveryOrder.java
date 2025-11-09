package template;

public class DeliveryOrder extends OrderTemplate {
    @Override
    protected void serveOrDeliver() {
        System.out.println("Delivering the order to the customers address.");
    }
}
