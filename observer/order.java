package observer;
import java.util.List;

public class order implements notifier {
    private List<Observer> observers;
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
