package observer;

public interface Notifier {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String order);
}
