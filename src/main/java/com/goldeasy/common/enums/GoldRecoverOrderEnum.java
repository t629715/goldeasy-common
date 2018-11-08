package com.goldeasy.common.enums;

/**
 * @Author: Mr.WuJiaNan
 * @Created time : 2018/11/8 15:00
 * @Description :
 */
public enum GoldRecoverOrderEnum {
    //订单状态:0:待完善 1:已生效 2:已失效 3已取消4:已完成
    INCOMPLETE("待完善",(short)0),
    INFORCE("已生效",(short)1),
    EXPIRED("已失效",(short)2),
    CANCELLED("已取消",(short)3),
    COMPLETED("已完成",(short)4);
    private String msg;
    private Short code;

    GoldRecoverOrderEnum(String msg, Short code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public Short getCode() {
        return code;
    }
}
