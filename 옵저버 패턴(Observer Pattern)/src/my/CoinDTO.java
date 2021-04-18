package my;

// 대충 coin 정보
public class CoinDTO {
    // 가격
    int bitcoinPrice;
    int ripplePrice;
    int adaPrice;

    // 거래량
    long bitcoinTradeVol;
    long rippleTradeVol;
    long adaTradeVol;

    public CoinDTO(int bitcoinPrice, int ripplePrice, int adaPrice, long bitcoinTradeVol, long rippleTradeVol, long adaTradeVol) {
        this.bitcoinPrice = bitcoinPrice;
        this.ripplePrice = ripplePrice;
        this.adaPrice = adaPrice;
        this.bitcoinTradeVol = bitcoinTradeVol;
        this.rippleTradeVol = rippleTradeVol;
        this.adaTradeVol = adaTradeVol;
    }

    public int getBitcoinPrice() {
        return bitcoinPrice;
    }


    public int getRipplePrice() {
        return ripplePrice;
    }


    public int getAdaPrice() {
        return adaPrice;
    }


    public long getBitcoinTradeVol() {
        return bitcoinTradeVol;
    }


    public long getRippleTradeVol() {
        return rippleTradeVol;
    }


    public long getAdaTradeVol() {
        return adaTradeVol;
    }


}
