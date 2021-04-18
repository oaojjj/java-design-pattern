package my;

import my.observer.PriceObserver;
import my.observer.TradeVolObserver;
import my.subject.BitcoinDataApi;

/**
 * 코인의 가격이 변하면 observer data를 자동으로 갱신
 */
public class Main {
    public static void main(String[] args) {
        BitcoinDataApi coinSubject = new BitcoinDataApi();

        // 구독
        PriceObserver pob = new PriceObserver(coinSubject);
        TradeVolObserver tvob = new TradeVolObserver(coinSubject);

        // 코인 정보 변화
        coinSubject.changedData(new CoinDTO(2000000, 1000, 2000, 30000000L, 12000000L, 10000000L));
        coinSubject.changedData(new CoinDTO(2100000, 1050, 2010, 31000000L, 12000500L, 10002000L));
        coinSubject.changedData(new CoinDTO(1900000, 2000, 2500, 64000000L, 32000000L, 20000000L));
        coinSubject.removeObserver(pob);
        System.out.println("-------가격 구독 해제-------");
        coinSubject.changedData(new CoinDTO(1900000, 2000, 2500, 64000000L, 32000000L, 20000000L));
    }
}
