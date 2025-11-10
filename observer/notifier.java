package observer;

public interface notifier {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String order);
}
