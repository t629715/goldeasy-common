package com.goldeasy.common.exception;

/**
 * @Author: Mr.wu
 * @Created time : 2018/10/22 10:32
 * @Description :
 */
public class GoldBuyException extends  RuntimeException {

    public GoldBuyException() {
    }

    public GoldBuyException(String message) {
        super(message);
    }

    public GoldBuyException(String message, Throwable cause) {
        super(message, cause);
    }

    public GoldBuyException(Throwable cause) {
        super(cause);
    }

    public GoldBuyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
