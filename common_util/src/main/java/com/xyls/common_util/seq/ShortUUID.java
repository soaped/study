package com.xyls.common_util.seq;

import java.util.UUID;


public class ShortUUID {

    private static final String[] CHARS = new String[] { "a", "b", "c", "d", "e", "f",  
        "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",  
        "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",  
        "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",  
        "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",  
        "W", "X", "Y", "Z" };  

    public static String generateShortUuid() {
        
        //本地时间/网卡/随机数
        String uuid = UUID.randomUUID().toString().replace("-", "");
        
        
        StringBuffer sb = new StringBuffer();  
        
        //分8组,模62的值作为索引
        for (int i = 0; i < 8; i++) {  
            String str = uuid.substring(i * 4, i * 4 + 4);  
            int x = Integer.parseInt(str, 16);  
            sb.append(CHARS[x % 0x3E]);  
        }  
        return sb.toString();  
      
    }  
}
