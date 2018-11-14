package com.goldeasy.common.enums;

/**
 * @Author: Mr.WuJiaNan
 * @Created time : 2018/11/1 13:35
 * @Description :
 */
public enum GoldPreConfStateEnum {

    NORMAL("正常规则",(short)1),
    PROHIBIT("强制开市",(short)2),
    FORCE("禁止交易",(short)3);
    private String msg;
    private Short code;
    GoldPreConfStateEnum(String msg, Short code) {
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
