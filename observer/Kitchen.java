package observer;

public class Kitchen implements Observer {

    @Override
    public void update(String order) {
        System.out.println("Kitchen is received new order: " + order);
    }
    
}
