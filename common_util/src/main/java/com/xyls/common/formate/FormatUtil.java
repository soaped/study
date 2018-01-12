/**
 * Copyright  2005 SilverStone Computer System Co.,Ltd
 *
 * History:
 *   2008-5-22 下午04:19:00 Created by dingwm
 */
package com.xyls.common.formate;

import com.alibaba.dubbo.common.utils.CollectionUtils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 格式辅助类
 * @author <a href="mailto:dingwm@ss-soft.com">dingwm</a>
 * @version 1.0  2008-5-22 下午04:19:00
 */
public class FormatUtil {
	
	public static String formatAmtFloat(String amt){
		if(amt == null || amt.trim().equals(""))
			return amt;
		return amt.replace( "," , "" );
	}
	
	//把金额格式转化成分为单位的格式
	public static String formatAmt2Fen(String amt){
		if(amt == null || amt.trim().equals(""))
			return amt;
		return amt.replace( "," , "" ).replace(".", "");
	}
	
	public static Double str2DoubleAmt(String amt){
		if(amt == null || amt.trim().equals(""))
			return new Double(0);
		return new Double(amt.replace(",", ""));
	}
	
	public static String double2StrAmt(Double amt){
		BigDecimal formatAmt = new BigDecimal(amt);
		formatAmt = formatAmt.setScale(2,BigDecimal.ROUND_HALF_UP);
		return formatAmt.toString();
	}
	
	//定长转成string型金额
	public static String fixedLength2StrAmt(String amt){
		if(amt==null || amt.trim().equals("")){
			return "";
		}
		BigDecimal formatAmt = new BigDecimal(new Double(amt)/100);
		formatAmt = formatAmt.setScale(2,BigDecimal.ROUND_HALF_UP);
		return formatAmt.toString();
	}
    // 元转换成分(不保留小数位)
    public static String fixedAmt2Integer(String amt){
        if(amt==null || amt.trim().equals("")){
            return amt;
        }
        BigDecimal formatAmt = new BigDecimal(amt).multiply(new BigDecimal("100")).setScale(0);
        return formatAmt.toPlainString();
    }

    //定长转成string型金额(金额为里)
    public static String fixedLength3StrAmt(String amt){
        if(amt==null || amt.trim().equals("")){
            return amt;
        }
        BigDecimal formatAmt = new BigDecimal(new Double(amt)/1000);
        formatAmt = formatAmt.setScale(3,BigDecimal.ROUND_HALF_UP);
        return formatAmt.toString();
    }

    // 元转换成分(不保留小数位，金额为里)
    public static String fixedAmt3Integer(String amt){
        if(amt==null || amt.trim().equals("")){
            return amt;
        }
        BigDecimal formatAmt = new BigDecimal(amt).multiply(new BigDecimal("1000")).setScale(0);
        return formatAmt.toPlainString();
    }

	//yyyy-MM-dd格式的字符串日期转化成yyyyMMdd格式的
	public static String strDateFormat(String strDate){
		if(strDate==null) return null;
		else if(strDate.trim().equals("")) return "";
		else return strDate.replace("-", "");
	}
	
	

	public static String strToStr(String str){
		if(str==null)
			return null;
		else if(str.trim().equals(""))
			return "";
		else
			return str.replace("-", "");
	}
	
	//取得校验位
	public static String getPanLrc( String card ){
		int i,sum,len;
		int ch;	   
		String WEIGHT="121212121212121212";
		if( card.length() > 18 ) return "";
		len = 18 - card.length(); 
		for( sum=0,i=0; i<card.length(); i++ ){
			int tmp = ( card.charAt(i)-'0' )* (WEIGHT.charAt(i+len)-'0');
			sum += ( tmp % 10 ) +( tmp / 10 );
		}
		ch=(10-sum%10)%10; // (int)'0';
		return ""+ch;
	} 
	

	
	
	//计算尾卡号
	public static String estimateEndPan(String startPan,Integer cardNum){
		if(cardNum.equals(1)){
			return startPan;
		}
		Long pan = new Long(startPan.substring(0,startPan.length()-1));
		pan = pan+cardNum-1;
		return ""+pan + getPanLrc(pan.toString());
	}
	//计算卡号
	public static String getEndPan(String startPan,Integer cardNum){
		if(cardNum.equals(1)){
			return startPan;
		}
		return estimateEndPan(startPan,cardNum);
	}
	
	public static String getDate(){
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		return dateFormat.format(new Date());
	}
	
	/**
	 * @param len	预定格式总长度
	 * @param ch	右补字符
	 * @param str	当前字符串
	 * @return
	 */
	public static String append(int len,String ch,String str){
		StringBuffer temp=new StringBuffer();
		String result="";
		if(str.getBytes().length>=len){
			return str;
		}
		else{
			for(int i=0;i<len-str.getBytes().length;i++){
				temp.append(ch);
			}
			result =  str + temp;
		}
		return result;
	}

    //定长转成string型金额
    public static String fixedLength2StrAmt(String amt, String defaultValue){
        if(amt==null || amt.trim().equals("")){
            return defaultValue;
        }
        BigDecimal formatAmt = new BigDecimal(new Double(amt)/100);
        formatAmt = formatAmt.setScale(2,BigDecimal.ROUND_HALF_UP);
        return formatAmt.toString();
    }

    public static String list2StringWithSeparator(List<String> list, String separator) {
        StringBuilder buff = new StringBuilder();
        if(CollectionUtils.isNotEmpty(list)) {
            for(String s: list) {
                buff.append(s).append(separator);
            }
            buff.deleteCharAt(buff.lastIndexOf(separator));
        }
        return buff.toString();
    }
}