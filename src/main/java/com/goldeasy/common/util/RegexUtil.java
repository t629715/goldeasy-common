package com.goldeasy.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Mr.wu
 * @Created time : 2018/10/15 17:37
 * @Description :
 */
public final class RegexUtil {
    /**静态类无需创建对象*/
    private RegexUtil(){}


    /**
     * @param mobileNumber 手机号
     * @return 返回类型 boolean; true:验证正确; false:验证错误
     * @author 武佳楠
     * @date 2017年11月13日上午11:39:41
     * @Description 验证手机号
     */
    public static boolean isMobileNumber(String mobileNumber) {
        // "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位
        String phone = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$";
        Pattern p = Pattern.compile(phone);
        Matcher m = p.matcher(mobileNumber);
        return m.matches();
    }

    /**
     * @param email 邮箱地址
     * @return 返回类型 boolean; true:验证正确; false:验证错误
     * @author 武佳楠
     * @date 2017年11月13日上午11:41:41
     * @Description 验证邮箱
     */
    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }


    /**
     * @param idCard 身份证号 18位或者15位
     * @return 返回类型 boolean; true:验证正确; false:验证错误
     * @author 武佳楠
     * @date 2017年11月14日上午9:10:26
     * @Description 身份证号检验
     */
    public static boolean isIdCard(String idCard) {
        //Pattern pattern = Pattern.compile("(^\\d{18}$)|(^\\d{15}$)");
        Pattern pattern = Pattern.compile("(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)"
                + "|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)");
        Matcher match = pattern.matcher(idCard);

        if (match.matches() == false) {
            return false;
        } else {
            return true;
        }
    }
    /**身份证号*/
    public static boolean validata(String no) {
        // 对身份证号进行长度等简单判断
        if (no == null || no.length() != 18 || !no.matches("\\d{17}[0-9X]")) {
            return false;
        }
        // 1-17位相乘因子数组
        int[] factor = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        // 18位随机码数组
        char[] random = "10X98765432".toCharArray();
        // 计算1-17位与相应因子乘积之和
        int total = 0;
        for (int i = 0; i < 17; i++) {
            total += Character.getNumericValue(no.charAt(i)) * factor[i];
        }
        // 判断随机码是否相等验证身份证是否为正确的身份证号   举个栗子 输入 正确的身份证号  改变随便改变一位数字或者字母(最后一位可能为x) 返回false
        //  注意 如果输入的身份号最后一位为x 一定要大写不然永远是false
        return random[total % 11] == no.charAt(17);
    }

    /**
     * @param bankCard 16位,19位银行卡号
     * @return 返回类型 boolean; true:验证正确; false:验证错误Í
     * @author 武佳楠
     * @date 2017年11月14日上午10:59:36
     * @Description 银行卡16位或者19位检查
     */
    public static boolean isBankCard(String bankCard) {
        Pattern pattern = Pattern.compile("^(\\d{16}|\\d{19})$");
        Matcher match = pattern.matcher(bankCard);

        if (match.matches() == false) {
            return false;
        } else {
            return true;
        }
    }

}
