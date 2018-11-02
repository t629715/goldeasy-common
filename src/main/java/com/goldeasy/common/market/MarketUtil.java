package com.goldeasy.common.market;

import com.alibaba.fastjson.JSON;
import com.goldeasy.common.redis.RedisService;
import com.goldeasy.common.util.MoneyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author: Mr.wu
 * @Created time : 2018/10/22 16:52
 * @Description :
 */
@Component
@PropertySource({"classpath:common.properties"})
public final class MarketUtil {

    @Resource
    private RedisService redisService;

    @Value("${gold.latest.market}")
    private String goldLatestMarket;



    public  Market getMarket() {
        String marketStr = redisService.get(goldLatestMarket);
        return JSON.parseObject(marketStr, Market.class);
    }
    /*实时价格*/
    public BigDecimal getNowPriceAddValue(BigDecimal value) {
        Market market = this.getMarket();
        BigDecimal nowPrice = MoneyUtil.yuanToFen(market.getPrice());
        return MoneyUtil.addRoundUp(value,nowPrice,0);
    }
    /*昨收价格*/
    public BigDecimal getPrePriceAddValue(BigDecimal value) {
        Market market = this.getMarket();
        BigDecimal nowPrice = MoneyUtil.yuanToFen(market.getPrevClosePx());
        return MoneyUtil.addRoundUp(value,nowPrice,0);
    }



}
