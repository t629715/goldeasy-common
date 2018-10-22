package com.goldeasy.common.market;

/**
 * Created by inggg on 2017/9/29.
 */
public class MarketSingleton {
    private static MarketSingleton ourInstance = new MarketSingleton();

    public static MarketSingleton getInstance() {
        return ourInstance;
    }

    private MarketSingleton() {
    }

    private Market goleMarket;

    public Market getGoleMarket() {
        /*此代码只适应测试环境，正式环境下请屏蔽*/
        if(goleMarket == null){
            goleMarket = new Market();
            goleMarket.setPrevClosePx(287.34);
        }
        return goleMarket;
    }

    public void setGoleMarket(Market goleMarket) {
        this.goleMarket = goleMarket;
    }
}
