package observer;
import java.util.List;
import java.util.ArrayList;
public class Order implements Notifier {
    private List<Observer> observers= new ArrayList<>();
    public void registerObserver(Observer o){
        observers.add(o);
    };
    public void removeObserver(Observer o){
        observers.remove(o);
    };
    public void notifyObservers(String order){
        for (Observer o : observers) {
            o.update(order);
        }
    };
}
