package com.goldeasy.common.enums;

/**
 * @Author: Mr.WuJiaNan
 * @Created time : 2018/11/7 10:42
 * @Description :
 */
public class GoldRecoverConfEnum {

    public  enum StateEnum{
        NORMAL_RECOVER("正常回收",(short)0),
        COMPULSORY_RECOVER("强制回收",(short)1),
        BAN_RECOVER("禁止回收",(short)2);
        private String msg;
        private Short code;

        StateEnum(String msg, Short code) {
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


    public  enum TypeEnum {
        NOW_PRICE("实收价+调整值",(short)0),
        PRE_PRICE("昨收价+调整值",(short)1),
        FIXED_PRICE("固定价",(short)2);
        private String msg;
        private Short code;

        TypeEnum(String msg, Short code) {
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


}
