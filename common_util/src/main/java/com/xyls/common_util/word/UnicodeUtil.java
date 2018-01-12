package com.xyls.common_util.word;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

public   class   UnicodeUtil   
{ 
	private static Logger logger = Logger.getLogger(UnicodeUtil.class);
	
	
	
	/**
     * 字符转换为16进制字符串(Unicode),前端可直接识别
     * @param s
     * @return
     */
    public static String toHexString(String s) {
	      StringBuffer sb = new StringBuffer();
	      if (s == null || s.equals(""))
		      return "";

	      for (int i = 0; i < s.length(); i++) {
		      char cChar = s.charAt(i);
		      if (isChinese(cChar)) {
			      sb.append("\\u");
			      sb.append(Integer.toHexString(cChar));
		      }else {
			      sb.append(cChar);
		      }
		  }
	      return sb.toString();
    }
    
	/**
	 * 字符转换为Unicode(中文转换,英文数字不转换)
	 * @s 输入字符串
	 * @replaceSpecialChar 是否替换wml特殊字符
	 * @return Unicode编码字符串
	 */
	public static String toUnicode(String s,boolean replaceSpecialChar ) {
	      StringBuffer sb = new StringBuffer();
	      if (s == null || s.equals(""))
		      return "";

	      for (int i = 0; i < s.length(); i++) {
		      char cChar = s.charAt(i);
		      if (isChinese(cChar)) {
			      sb.append("&#x");
			      sb.append(Integer.toHexString(cChar));
			      sb.append(";");
		      }else {
		    	  if(replaceSpecialChar){
		    		  switch (cChar) {
		    			case 32: // ' '
		    			  sb.append("&#32;");
		    			  break;
		    			case 34: // '"'
		    			  sb.append("&quot;");
		    			  break;
		    			case 60: // '<'
		    			  sb.append("&lt;");
		    			  break;
		    			case 62: // '>'
		    			  sb.append("&gt;");
		    			  break;
		    			case 38: // '&'
		    			  sb.append("&amp;");
		    			  break;
		    			default:
		    			  sb.append(cChar);
		    			  break;
		    		      }
		    	  }else{
		    		  sb.append(cChar);
		    	  }
		      }
		  }
	      return sb.toString();
    }
    private static boolean isChinese(char c) {
    	Character ch = new Character(c);
    	String sCh = ch.toString();
    	try {
    		byte[] bb = sCh.getBytes("gb2312");
    		if (bb.length > 1)
    			return true;
			      /*
			       * for (int i=0; i <bb.length; i++) { Byte bTmp = new Byte(bb[i]);
			       * System.out.println("char["+ i + "]:" +
			       * Integer.toHexString(bTmp.intValue())); }
			       */
    	} catch (UnsupportedEncodingException ue) {
    		logger.error(ue);
    		return false;
    	}
    	return false;
    }
	
    
    
    /**
	 * 字符转换为Unicode(全部转换,包括数字和英文)
	 * @s 输入字符串
	 * @encode 将会用置顶编码方式进行验证
	 * @return Unicode编码字符串
	 */
     public static String StringToUnicode(String s,String encode){
    	String result = "";
    	int input;
    	StringReader isr;
    	try {
	      isr = new StringReader(new String(s.getBytes(), encode));
    	}
    	catch (UnsupportedEncodingException e) {
    		logger.error(e);
    		return "-1";
    	}

    	try {
    		while ( (input = isr.read()) != -1) {
    			result = result + "&#x" + Integer.toHexString(input) + ";";
    		}
    	}
    	catch (IOException e) {
    		logger.error(e);
    		return "-2";
    	}
    	isr.close();
    	return result;
      }
     
     
     
     
     
     
     
     
     
     
     
     
     /**
      * Unicode(&#x54c8或\u56fe)转换为字符
      * @s 待转换的Unicode字符
      * @return 转换完毕的字符串
      */
     public static String UnicodeToString(String s){
 		String result = s;
 		while(true){
 		int index1 = result.indexOf("&#x") + 3;
 		if(index1 == 2) break;
 		int index2 = result.indexOf(";",index1);
 		String s1 = result.substring(index1,index2);
 		result = result.replace("&#x"+s1+";", decodeUnicode("0x"+s1));
 		}
 		
 		//&#31227的形式(10进制表示汉字)
 		while(true){
 			int index1 = result.indexOf("&#") + 2;
 			if(index1 == 1) return result;
 			int index2 = result.indexOf(";",index1);
 			String s1 = result.substring(index1,index2);
 			result = result.replace("&#"+s1+";", decodeUnicode("0x"+Integer.toHexString(Integer.parseInt(s1))));
 			
 			}
 	}
     
     
     private static String decodeUnicode(final String dataStr ) { 
         int start = 0;
         int end = 0;
         final StringBuffer buffer = new StringBuffer();
         while( start > -1 ) {
           end = dataStr.indexOf( "\\u", start + 2 );
           String charStr = "";
           if( end == -1 ) {
             charStr = dataStr.substring( start + 2, dataStr.length() );
           } else {
             charStr = dataStr.substring( start + 2, end);
           }
           char letter = (char) Integer.parseInt( charStr, 16 );
           buffer.append( new Character( letter ).toString() );
           start = end;
         }
         return buffer.toString();
     }
     
     
     
     
     
     
     
     
     
     
     
     
}