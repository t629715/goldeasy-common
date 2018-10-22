package com.goldeasy.common.market;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * Created by inggg on 2017/9/28.
 */
public class QueueListener implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(QueueListener.class);

    @Override
    public void onMessage(Message message) {
      logger.info(""+message);
        String string = new String(message.getBody());
        logger.info("=====================>"+string);
        Market market = JSON.parseObject(string, Market.class);
        logger.info("Received <" + market.getTime() + ":" + market.getPrice() + ">");
        MarketSingleton.getInstance().setGoleMarket(market);
    }
}
