package observer;

public class Waiter implements Observer {

    @Override
    public void update(String order) {
        System.out.println("waiter get the order info "  + order);
    }
    
}