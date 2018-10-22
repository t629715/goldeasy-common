package com.goldeasy.common.market;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * @Author: Mr.wu
 * @Created time : 2018/10/22 15:02
 * @Description :
 */
@Configuration
//@PropertySource("classpath:rabbitmq.yml")
public class RabbitMQConf {
    /*账号*/
    @Value("${rabbitmq.username}")
    private String username;
    /*密码*/
    @Value("${rabbitmq.password}")
    private String password;
    /*地址*/
    @Value("${rabbitmq.addresses}")
    private String addresses;
    /***/
    @Value("${rabbitmq.cache.channel.size}")
    private Integer channelCacheSize;

    @Value("${rabbitmq.publisher-confirms}")
    private boolean publisherConfirms;

    @Value("${rabbitmq.publisher-returns}")
    private boolean publisherReturns;

    @Value("${gold.exchange.name}")
    private String exchangeName;

    @Value("${gold.market.routing}")
    private String goldRoutingKey;



    @Bean(name = "goldMarketQueue")
    MyQueue queue() {
        return new MyQueue(goldRoutingKey, true, false, true);
    }
    @Bean
    TopicExchange exchange() {
        return new TopicExchange(exchangeName, false, false);
    }

    @Bean
    Binding binding(@Qualifier("goldMarketQueue") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(goldRoutingKey);
    }

    @Bean(name = "goldMarketListener")
    MessageListener messageListener() {
        return new QueueListener();
    }


    @Bean
    SimpleMessageListenerContainer simpleMessageListenerContainer(ConnectionFactory connectionFactory, @Qualifier("goldMarketQueue") Queue queue, @Qualifier("goldMarketListener") MessageListener messageListener) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setAcknowledgeMode(AcknowledgeMode.NONE);
        container.setQueues(queue);
        container.setMessageListener(messageListener);
        return container;
    }

    @Bean
    ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(addresses);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setChannelCacheSize(channelCacheSize);
        connectionFactory.setPublisherConfirms(publisherConfirms);
        connectionFactory.setPublisherReturns(publisherReturns);
        return connectionFactory;
    }
}
