package template;
public class DineInOrder extends OrderTemplate {
    @Override
    protected void serveOrDeliver() {
        System.out.println("Serving the order at the dining table.");
    }

}
