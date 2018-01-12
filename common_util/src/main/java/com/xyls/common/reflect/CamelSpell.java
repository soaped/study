package com.xyls.common.reflect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/6/24.
 */
public class CamelSpell {

    public static void main(String [] args){
        String s = "abc_a";
        System.out.println(toSpell(CamelSpell.toCamelSpell(s)));
    }

    /**
     * 下划线转驼峰
     * @param s
     * @return
     */
    public static String toCamelSpell(String s){
        Matcher matcher = Pattern.compile("_.").matcher(s);

        while(matcher.find()){
            s = s.replaceAll(matcher.group(0),new String(new char[]{matcher.group(0).charAt(1)}).toUpperCase());
        }
        return s;
    }


    /**
     * 驼峰转下划线
     */
    private static Pattern humpPattern = Pattern.compile("[A-Z]");
    public static String toSpell(String str){
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, "_"+matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
