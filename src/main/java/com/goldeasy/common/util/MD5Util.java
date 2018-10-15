package com.goldeasy.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
* @ClassName: MD5Utils 
* @Description: 用户密码加密工具类
* @author jcwang
* @date 2017年8月1日 下午3:34:42 
*
 */
public class MD5Util {
	private static String salt = "ggsimida";
	
	/**
	 * 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param sourceStr
	 * @return
	 * @author jcwang
	 * @date 2017年8月1日 下午3:44:37
	 */
	 public static String encrypt(String sourceStr) {
	        try {
	            // 获得MD5摘要算法的 MessageDigest对象  
	            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
	            String sourcesalt = sourceStr+salt;
	            // 使用指定的字节更新摘要  
	            mdInst.update(sourcesalt.getBytes());  
	            // 获得密文  
	            byte[] md = mdInst.digest();
	            // 把密文转换成十六进制的字符串形式  
	            StringBuffer buf = new StringBuffer();  
	            for (int i = 0; i < md.length; i++) {  
	                int tmp = md[i];  
	                if (tmp < 0)  
	                    tmp += 256;  
	                if (tmp < 16)  
	                    buf.append("0");  
	                buf.append(Integer.toHexString(tmp));  
	            }  
	            //return buf.toString().substring(8, 24);// 16位加密  
	             return buf.toString();// 32位加密  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            return null;  
	        }
	    }  
	 
	    public static void main(String[] args) {
	        String str = "q123456"+salt;
	        String encryptStr = getMD5(str); ////625b1e027b7912d420057243f9e57e5b 38172115C64EC067413B9CB9A50ADC26
	        System.out.println("加密前：" + "6777kepdwuekflpwkjksaeoer");
	        System.out.println("加密后：" + encryptStr);
	    }

	public static String getMD5(String orginalString) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] bs = orginalString.getBytes("UTF-8");
			byte[] buff = digest.digest(bs);
			StringBuffer md5Buffer = new StringBuffer();
			int digital;
			for (int i = 0; i < buff.length; i++) {
				digital = buff[i];

				if (digital < 0) {
					digital += 256;
				}
				if (digital < 16) {
					md5Buffer.append("0");
				}
				md5Buffer.append(Integer.toHexString(digital));
			}
			return md5Buffer.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
}  
