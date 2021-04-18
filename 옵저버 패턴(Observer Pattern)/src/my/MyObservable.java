package my;

public interface MyObservable {
    void addObserver(MyObserver observer);
    void removeObserver(MyObserver observer);
    void notifyObservers();
}
