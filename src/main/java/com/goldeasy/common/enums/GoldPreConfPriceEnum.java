package com.goldeasy.common.enums;

/**
 * @Author: Mr.WuJiaNan
 * @Created time : 2018/11/1 13:35
 * @Description :
 */
public enum GoldPreConfPriceEnum {

    PRE_PRICE("昨收价+调整值",(short)0),
    NOW_PRICE("实收价+调整值",(short)1),
    FIXED_PRICE("固定价",(short)2);
    private String msg;
    private Short code;
    GoldPreConfPriceEnum(String msg, Short code) {
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
