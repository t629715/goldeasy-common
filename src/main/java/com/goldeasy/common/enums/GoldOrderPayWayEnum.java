package com.goldeasy.common.enums;

/**
 * @Author: Mr.WuJiaNan
 * @Created time : 2018/11/1 13:35
 * @Description :
 */
public enum GoldOrderPayWayEnum {

    ALI_PAY("支付宝",(short)0),
    WECHAT_PAY("微信",(short)1),
    UNION_PAY("银联",(short)2);
    private String msg;
    private Short code;
    GoldOrderPayWayEnum(String msg, Short code) {
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
