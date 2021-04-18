package my.observer;

import my.CoinDTO;
import my.MyObservable;
import my.MyObserver;
import my.subject.BitcoinDataApi;

import java.text.DecimalFormat;

/**
 * 나는 coin data를 받아서 거래량을 표시할거야.
 */
public class TradeVolObserver implements MyObserver {
    private MyObservable subject;

    public TradeVolObserver(MyObservable observable) {
        subject = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(MyObservable observable, Object arg) {
        if (observable instanceof BitcoinDataApi) {
            subject = observable;
            BitcoinDataApi coinData = (BitcoinDataApi) observable;
            showTradeVolume(coinData.getCoins());
        }
    }

    public void showTradeVolume(CoinDTO coins) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        System.out.println("대충 거래량 보여주는 멋있는 UI");
        System.out.println("bitcoin volume:" + formatter.format(coins.getBitcoinTradeVol()));
        System.out.println("ada volume:" + formatter.format(coins.getAdaTradeVol()));
        System.out.println("ripple volume:" + formatter.format(coins.getRippleTradeVol()));
        System.out.println("--------------------------");
    }
}
