package com.goldeasy.common.market;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;

import java.util.Map;
import java.util.UUID;

/**
 * Created by inggg on 2017/10/13.
 */
public class MyQueue extends Queue {
    private static final Logger logger = LoggerFactory.getLogger(MyQueue.class);

    public MyQueue(boolean durable, boolean exclusive, boolean autoDelete) {
        this(UUID.randomUUID().toString(), durable, exclusive, autoDelete);
    }

    public MyQueue(String name) {
        super(name);
    }

    public MyQueue(String name, boolean durable) {
        super(name, durable);
    }

    public MyQueue(String name, boolean durable, boolean exclusive, boolean autoDelete) {
        super(name, durable, exclusive, autoDelete);
    }

    public MyQueue(String name, boolean durable, boolean exclusive, boolean autoDelete,
        Map<String, Object> arguments) {
        super(name, durable, exclusive, autoDelete, arguments);
    }

}
