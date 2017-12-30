package com.yangfuzhao.mybatus_plugin;

/**
 * Created by ipaynow0929 on 2017/12/29.
 */
public class StringUtils {

    public static boolean isEmpty(String s) {

        if (s == null || s.length() == 0){
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(String s) {
      return !isEmpty(s);
    }
}
