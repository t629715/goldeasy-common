package com.goldeasy.common.util;


import java.math.BigDecimal;

/**
 * @Author: Mr.wu
 * @Created time : 2018/10/18 16:47
 * @Description : BigDecimal 本项目工具类
 */
public final class MoneyUtil {


    private MoneyUtil() {
    }

    /*
     * @Author: Mr.wu
     * @Description:   元转分
     * @Date: 2018/10/18 16:53
     * @param: yuan
     * @return: java.math.BigDecimal
     * @Version: 1.0
     */
    public static BigDecimal yuanToFen(BigDecimal yuan) {
        return yuan.multiply(new BigDecimal(100)).setScale(0);
    }

    public static BigDecimal yuanToFen(String yuan) {
        return yuanToFen(new BigDecimal(yuan));
    }

    public static BigDecimal yuanToFen(Double yuan) {
        return yuanToFen(new BigDecimal(yuan + ""));
    }

    public static BigDecimal yuanToFen(Integer yuan) {
        return yuanToFen(new BigDecimal(yuan));
    }


    /*
     * @Author: Mr.wu
     * @Description:  分转元
     * @Date: 2018/10/18 16:57
     * @param: fen
     * @return: java.math.BigDecimal
     * @Version: 1.0
     */
    public static BigDecimal fenToYuan(BigDecimal fen) {
        return fen.divide(new BigDecimal(100));
    }

    public static BigDecimal fenToYuan(String fen) {
        return fenToYuan(new BigDecimal(fen));
    }

    public static BigDecimal fenToYuan(Double fen) {
        return fenToYuan(new BigDecimal(fen + ""));
    }

    public static BigDecimal fenToYuan(Integer fen) {
        return fenToYuan(new BigDecimal(fen));
    }

    /**
     * 乘法舍去模式
     */
    public static BigDecimal multiplyRoundDown(BigDecimal b1, BigDecimal b2, int scale) {
        return b1.multiply(b2).setScale(scale, BigDecimal.ROUND_DOWN);
    }

    public static BigDecimal multiplyRoundDown(Double b1, Double b2, int scale) {
        BigDecimal bd1 = new BigDecimal(b1 + "");
        BigDecimal bd2 = new BigDecimal(b2 + "");
        return multiplyRoundDown(bd1, bd2, scale);
    }

    public static BigDecimal multiplyRoundDown(BigDecimal b1, Double b2, int scale) {
        BigDecimal bd2 = new BigDecimal(b2 + "");
        return multiplyRoundDown(b1, bd2, scale);
    }


    /*除法 舍去模式*/
    public static BigDecimal divideRoundDown(BigDecimal b1, BigDecimal b2, int scale) {
        return b1.divide(b2, scale, BigDecimal.ROUND_DOWN);
    }

    public static BigDecimal divideRoundDown(BigDecimal b1, double b2, int scale) {
        BigDecimal bd2 = new BigDecimal(b2 + "");
        return divideRoundDown(b1, bd2, scale);
    }

    public static BigDecimal divideRoundDown(Double b1, BigDecimal b2, int scale) {
        BigDecimal bd1 = new BigDecimal(b1 + "");
        return divideRoundDown(bd1, b2, scale);
    }

    public static BigDecimal divideRoundDown(Double b1, Double b2, int scale) {
        BigDecimal bd1 = new BigDecimal(b1 + "");
        BigDecimal bd2 = new BigDecimal(b2 + "");
        return divideRoundDown(bd1, bd2, scale);
    }

    /************减法 舍去模式*****/
    public static BigDecimal subtractRoundDown(BigDecimal b1, BigDecimal b2, int scale) {
        return b1.subtract(b2).setScale(scale, BigDecimal.ROUND_DOWN);
    }

    public static BigDecimal subtractRoundDown(Double b1, Double b2, int scale) {
        BigDecimal bd1 = new BigDecimal(b1 + "");
        BigDecimal bd2 = new BigDecimal(b2 + "");
        return subtractRoundDown(bd1, bd2, scale);
    }
    public static BigDecimal subtractRoundDown(BigDecimal b1, Double b2, int scale) {
        BigDecimal bd2 = new BigDecimal(b2 + "");
        return subtractRoundDown(b1, bd2, scale);
    }
    public static BigDecimal subtractRoundDown(Double b1, BigDecimal b2, int scale) {
        BigDecimal bd1= new BigDecimal(b1 + "");
        return subtractRoundDown(bd1, b2, scale);
    }

    /************加法 舍去模式*****/
    public static BigDecimal addRoundDown(BigDecimal b1, BigDecimal b2, int scale) {
        return b1.add(b2).setScale(scale, BigDecimal.ROUND_DOWN);
    }

    public static BigDecimal addRoundDown(Double b1, Double b2, int scale) {
        BigDecimal bd1 = new BigDecimal(b1 + "");
        BigDecimal bd2= new BigDecimal(b2 + "");
        return addRoundDown(bd1,bd2,scale);
    }
    public static BigDecimal addRoundDown(BigDecimal b1, Double b2, int scale) {
        BigDecimal bd2= new BigDecimal(b2 + "");
        return addRoundDown(b1,bd2,scale);
    }


    /**
     * 乘法 +1模式
     */
    public static BigDecimal multiplyRoundUp(BigDecimal b1, BigDecimal b2, int scale) {
        return b1.multiply(b2).setScale(scale, BigDecimal.ROUND_UP);
    }

    public static BigDecimal multiplyRoundUp(BigDecimal b1, Integer b2, int scale) {
        return b1.multiply(new BigDecimal(b2)).setScale(scale, BigDecimal.ROUND_UP);
    }
    public static BigDecimal multiplyRoundUp(Double b1, Double b2, int scale) {
        BigDecimal bd1 = new BigDecimal(b1 + "");
        BigDecimal bd2 = new BigDecimal(b2 + "");
        return multiplyRoundUp(bd1, bd2, scale);
    }

    public static BigDecimal multiplyRoundUp(BigDecimal b1, Double b2, int scale) {
        BigDecimal bd2 = new BigDecimal(b2 + "");
        return multiplyRoundUp(b1, bd2, scale);
    }


    /*除法 +1模式*/
    public static BigDecimal divideRoundUp(BigDecimal b1, BigDecimal b2, int scale) {
        return b1.divide(b2, scale, BigDecimal.ROUND_UP);
    }

    public static BigDecimal divideRoundUp(BigDecimal b1, double b2, int scale) {
        BigDecimal bd2 = new BigDecimal(b2 + "");
        return divideRoundUp(b1, bd2, scale);
    }

    public static BigDecimal divideRoundUp(Double b1, BigDecimal b2, int scale) {
        BigDecimal bd1 = new BigDecimal(b1 + "");
        return divideRoundUp(bd1, b2, scale);
    }

    public static BigDecimal divideRoundUp(Double b1, Double b2, int scale) {
        BigDecimal bd1 = new BigDecimal(b1 + "");
        BigDecimal bd2 = new BigDecimal(b2 + "");
        return divideRoundUp(bd1, bd2, scale);
    }

    /************减法 +1模式*****/
    public static BigDecimal subtractRoundUp(BigDecimal b1, BigDecimal b2, int scale) {
        return b1.subtract(b2).setScale(scale, BigDecimal.ROUND_UP);
    }

    public static BigDecimal subtractRoundUp(Double b1, Double b2, int scale) {
        BigDecimal bd1 = new BigDecimal(b1 + "");
        BigDecimal bd2 = new BigDecimal(b2 + "");
        return subtractRoundUp(bd1, bd2, scale);
    }
    public static BigDecimal subtractRoundUp(BigDecimal b1, Double b2, int scale) {
        BigDecimal bd2 = new BigDecimal(b2 + "");
        return subtractRoundUp(b1, bd2, scale);
    }
    public static BigDecimal subtractRoundUp(Double b1, BigDecimal b2, int scale) {
        BigDecimal bd1= new BigDecimal(b1 + "");
        return subtractRoundUp(bd1, b2, scale);
    }

    /************加法 +1模式*****/
    public static BigDecimal addRoundUp(BigDecimal b1, BigDecimal b2, int scale) {
        return b1.add(b2).setScale(scale, BigDecimal.ROUND_UP);
    }

    public static BigDecimal addRoundUp(Double b1, Double b2, int scale) {
        BigDecimal bd1 = new BigDecimal(b1 + "");
        BigDecimal bd2= new BigDecimal(b2 + "");
        return addRoundUp(bd1,bd2,scale);
    }
    public static BigDecimal addRoundUp(BigDecimal b1, Double b2, int scale) {
        BigDecimal bd2= new BigDecimal(b2 + "");
        return addRoundUp(b1,bd2,scale);
    }

    public static void main(String[] args) {
        BigDecimal b1 = MoneyUtil.addRoundDown(123.123D, 0.001D, 2);//123.12
        BigDecimal b2 = MoneyUtil.addRoundUp  (123.123D,  0.001D, 2);//123.13


    }

}
