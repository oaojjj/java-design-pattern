package my.subject;

import my.CoinDTO;
import my.MyObservable;
import my.MyObserver;

import java.util.ArrayList;

// java.util에 포함 되있는 Observable, Observer을 이용해서 구현해도 된다.
// 단, 자바에서 지원하는 Observable은 클래스이다.
public class BitcoinDataApi implements MyObservable {
    private ArrayList<MyObserver> observers;
    private CoinDTO coins;

    public BitcoinDataApi() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(MyObserver observer) {
        if (observers != null)
            observers.add(observer);
    }

    @Override
    public void removeObserver(MyObserver observer) {
        if (observers != null)
            observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(this, coins));
    }

    // 간단하게 실시간 코인 정보를 수집한다고 가정한다..
    public void changedData(CoinDTO coins) {
        this.coins = coins;
        notifyObservers();
    }

    public CoinDTO getCoins() {
        return coins;
    }
}
