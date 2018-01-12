package com.xyls.common_util.main;

import java.util.ArrayList;
import java.util.List;


public class CustomDefineParams {

    private List<Bean> beans = new ArrayList<Bean>();
    
    public CustomDefineParams define(String desc,String key){
        beans.add(new Bean(desc,key));
        return this;
    }
    public  String getValue(String key){
        for(Bean bean : beans){
            if(bean.getKey().equals(key)){
                return bean.getValue();
            }
        }
        return null;
    }
    public CustomDefineParams getCustomInput(){
        for(Bean bean : beans){
            java.util.Scanner sc = new java.util.Scanner(System.in);
            System.out.println(bean.getDesc());
            bean.setValue(sc.next());
        }
        return this;
    }
    
    
    public static void main(String [] args){
        System.out.println(
                
                new CustomDefineParams()
                .define("1.", "a")
                .define("2.", "b")
                .define("c.", "c")
                .getCustomInput().getValue("b")
                
                );
        
    }
}


class Bean{
    public Bean(String desc,String key){
        this.desc = desc;
        this.key = key;
    }
    private String desc;
    private String key;
    private String value;
    
    
    public String getValue() {
    
        return value;
    }

    
    public void setValue(String value) {
    
        this.value = value;
    }

    public String getDesc() {
    
        return desc;
    }
    
    public void setDesc(String desc) {
    
        this.desc = desc;
    }
    
    public String getKey() {
    
        return key;
    }
    
    public void setKey(String key) {
    
        this.key = key;
    }
    
}