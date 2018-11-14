package com.goldeasy.common.enums;

/**
 * @Author: Mr.WuJiaNan
 * @Created time : 2018/11/1 13:35
 * @Description :
 */
public enum GoldOrderTypeEnum {
   // order_type` smallint(2) DEFAULT NULL COMMENT '0预购订单、1商城订单、2金权交易的提金订单',
    PRE_ORDER("0预购订单",(short)0),
    STORE_ORDER("商城订单",(short)1),
    JQ_ORDER("金权交易的提金订单",(short)2);
    private String msg;
    private Short code;
    GoldOrderTypeEnum(String msg, Short code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Short getCode() {
        return code;
    }

    public void setCode(Short code) {
        this.code = code;
    }
}
