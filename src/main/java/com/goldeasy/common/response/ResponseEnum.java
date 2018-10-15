package com.goldeasy.common.response;

/**
 * Created by Administrator on 2018/10/15.
 * @author xiejunxing
 */
public enum ResponseEnum {

    /**
     * 操作成功返回码
     */
    SUCCESS(1001,"成功"),
    /**
     * 操作失败或条件达不到返回码
     */
    FAILED(1002,"失败"),
    /**
     * 系统异常
     */
    ERROR(1003,"系统异常"),

    NO_ACCESS(1004,"无操作权限"),

    ACCOUNT_FORBIDDEN(1005,"账号被禁");

    Integer code;
    String msg;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    ResponseEnum() {
    }
}
