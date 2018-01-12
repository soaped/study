package com.xyls.common.math;

import java.math.BigDecimal;
import java.text.DecimalFormat;


public   class   MathUtil   
{ 
    
	/**
	 * 对数据进行取精度
	 * 
	 * @value 数据
	 * @scale 精度未数(保留的小数位数)
	 * @roundingMode 精度的取值方式<br/>
	 * 如scale == 2<br/>
	 * BigDecimal.ROUND_UP,只要第二位后面存在大于0的小数,则第二位就+1<br/>
	 * BigDecimal.ROUND_DOWN,与ROUND_UP相反,直接舍去第二位后面的所有小数<br/>
	 * BigDecimal.ROUND_CEILING,若数字>0则和ROUND_UP一样,若数字<0则和ROUND_DOWN一样<br/>
	 * BigDecimal.ROUND_FLOOR,若数字>0则和ROUND_DOWN一样,若数字<0则和ROUND_UP一样<br/>
	 * BigDecimal.ROUND_HALF_UP,最常用的方法,若第三位数字>=5,则第二位数字+1<br/>
	 * BigDecimal.ROUND_HALF_DOWN,若第三位数字>=5,则做ROUND_UP,否则做ROUND_DOWN<br/>
	 * @return 精度计算后的数据
	 */
	public static double round(double value, int scale, int roundingMode) {   
        BigDecimal bd = new BigDecimal(value);   
        bd = bd.setScale(scale, roundingMode);   
        double d = bd.doubleValue();
        bd = null;   
        return d;   
    }   
	
	
	
	/**
	 * 按模式取精度(四舍五入,不足补0)
	 * 
	 * @value 数据
	 * @model 模式,如0.00, 0.0<br/>
	 * @return 精度计算后的数据
	 */
	public static String DecimalFormatModel(String value,String model){
		Double p = Double.parseDouble(value);
		DecimalFormat df = new DecimalFormat(model);
		return df.format(p);
	}
	
	
	public static int min(int a,int b){
		if(a<b){
			return a;
		}else{
			return b;
		}
	}
	public static int max(int a,int b){
		if(a>b){
			return a;
		}else{
			return b;
		}
	}
	
	
	
	
	
	public static void main(String [] args){
	    System.out.println(MathUtil.DecimalFormatModel("-12.17","0.0"));//-12.2
        System.out.println(MathUtil.DecimalFormatModel("12.1712","0.00"));//12.17
 
        
        System.out.println(MathUtil.round(12.3401,2,BigDecimal.ROUND_UP));//12.35   
        System.out.println(MathUtil.round(-12.3401,2,BigDecimal.ROUND_UP));//-12.35   

        System.out.println(MathUtil.round(12.349,2,BigDecimal.ROUND_DOWN));//12.34   
        System.out.println(MathUtil.round(-12.349,2,BigDecimal.ROUND_DOWN));//-12.34   

        System.out.println(MathUtil.round(12.3401,2,BigDecimal.ROUND_CEILING));//12.35   
        System.out.println(MathUtil.round(-12.349,2,BigDecimal.ROUND_CEILING));//-12.34   

        System.out.println(MathUtil.round(12.349,2,BigDecimal.ROUND_FLOOR));//12.34   
        System.out.println(MathUtil.round(-12.3401,2,BigDecimal.ROUND_FLOOR));//-12.35   

        System.out.println(MathUtil.round(12.345,2,BigDecimal.ROUND_HALF_UP));//12.35   
        System.out.println(MathUtil.round(12.3449,2,BigDecimal.ROUND_HALF_UP));//12.34   
        System.out.println(MathUtil.round(-12.345,2,BigDecimal.ROUND_HALF_UP));//-12.35   
        System.out.println(MathUtil.round(-12.3449,2,BigDecimal.ROUND_HALF_UP));//-12.34   

        System.out.println(MathUtil.round(12.345,2,BigDecimal.ROUND_HALF_DOWN));//12.35   
        System.out.println(MathUtil.round(12.3449,2,BigDecimal.ROUND_HALF_DOWN));//12.34   
        System.out.println(MathUtil.round(-12.345,2,BigDecimal.ROUND_HALF_DOWN));//-12.35   
        System.out.println(MathUtil.round(-12.3449,2,BigDecimal.ROUND_HALF_DOWN));//-12.34   

        System.out.println(MathUtil.round(12.346,2,BigDecimal.ROUND_HALF_EVEN));//12.35   
        System.out.println(MathUtil.round(12.345,2,BigDecimal.ROUND_HALF_EVEN));//12.35
        
        
       
        
        int s  = (int)(MathUtil.round(-0.0033422587,4,BigDecimal.ROUND_HALF_UP) * 10000);
        double ss = (double)s/100;
        System.out.println(s);
        System.out.println(ss);
	}
}