package com.goldeasy.common.response;

/**
 * Created by Administrator on 2018/10/15.
 * @author xiejunxing
 */
public class CommonResponse {
    /**
     *  返回码
     */
    private Integer code;
    /**
     * 返回提示信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private Object data;

    public static CommonResponse success(String message){
        return new CommonResponse(ResponseEnum.SUCCESS.getCode(),message);
    }
    public static CommonResponse success(String message,Object data){
        return new CommonResponse(ResponseEnum.SUCCESS.getCode(),message,data);
    }

    public static CommonResponse fail(String message){
        return new CommonResponse(ResponseEnum.FAILED.getCode(),message);
    }

    public static CommonResponse error(String message){
        return new CommonResponse(ResponseEnum.ERROR.getCode(),message);
    }

    public static CommonResponse response(int code,String message){
        return new CommonResponse(code,message);
    }

    public static CommonResponse response(int code,String message,Object data){
        return new CommonResponse(code,message,data);
    }


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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public CommonResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonResponse(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
