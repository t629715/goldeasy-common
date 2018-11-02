package com.goldeasy.common.enums;

/**
 * @Author: Mr.WuJiaNan
 * @Created time : 2018/11/1 13:35
 * @Description :
 */
public enum GoldOrderStatusEnum {

    NOPAY("未支付",(short)0),
    COMPLETE_PAY("已支付",(short)1),
    SEND_OUT("已发货",(short)2),
    COMPLETE_ORDER("已完成",(short)3),
    CANCEL("已取消或作废",(short)4);
    private String msg;
    private Short code;
    GoldOrderStatusEnum(String msg, Short code) {
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
