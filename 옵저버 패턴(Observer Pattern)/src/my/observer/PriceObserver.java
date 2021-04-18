package my.observer;

import my.CoinDTO;
import my.MyObservable;
import my.MyObserver;
import my.subject.BitcoinDataApi;

import java.text.DecimalFormat;

/**
 * 나는 coin data를 받아서 가격을 표시할거야.
 */
public class PriceObserver implements MyObserver {
    private MyObservable subject;

    public PriceObserver(MyObservable observable) {
        subject = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(MyObservable observable, Object arg) {
        if (observable instanceof BitcoinDataApi) {
            subject = observable;
            BitcoinDataApi coinData = (BitcoinDataApi) observable;
            showPrice(coinData.getCoins());
        }
    }

    public void showPrice(CoinDTO coins) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        System.out.println("대충 가격 보여주는 멋있는 UI");
        System.out.println("bitcoin price:" + formatter.format(coins.getBitcoinTradeVol()) + "원");
        System.out.println("ada price:" + formatter.format(coins.getAdaTradeVol()) + "원");
        System.out.println("ripple price:" + formatter.format(coins.getRippleTradeVol()) + "원");
        System.out.println("--------------------------");
    }
}
