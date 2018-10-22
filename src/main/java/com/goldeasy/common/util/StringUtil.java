package com.goldeasy.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Mr.wu
 * @Created time : 2018/10/22 17:29
 * @Description :
 */
public final class StringUtil {


    private StringUtil() {
    }

    public static List<String> getDataList(String str){
        if (str==null){
            return null;
        }
        String[] split = str.split(",");
        List<String> list = new ArrayList<>();
        Collections.addAll(list,split);
        return list;
    }

    public static String[] getDataArray(String str){
        if (str==null){
            return null;
        }
        return str.split(",");

    }

}
