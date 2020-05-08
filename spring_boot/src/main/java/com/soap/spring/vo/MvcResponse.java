package com.soap.spring.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * UserInfo: Z
 * Date: 16-7-9
 * Time: 下午12:45
 * To change this template use File | Settings | File Templates.
 */
@Data
public class MvcResponse {

    private Head head;
    private Object body;



    public static MvcResponse generrateSucessMvcResponse(Object data){
        return new MvcResponse("0","成功",data);
    }
    public static MvcResponse generrateFailMvcResponse(String message){
        return new MvcResponse("1",message,null);
    }
    public static MvcResponse generrateSessionTimeOutMvcResponse(){
        return new MvcResponse("2", "会话超时",null);
    }
    public static MvcResponse generratePermissionLimitMvcResponse(){
        return new MvcResponse("3","权限拦截",null);
    }
    public static MvcResponse generratePermissionUnConfigMvcResponse(){ return new MvcResponse("4","权限未配置",null);}
    public static MvcResponse generrateUnknownExceptionMvcResponse(){ return new MvcResponse("9","未知异常",null);}


    private MvcResponse(String respCode, String respMsg) {
        this.head = new Head(respCode, respMsg);
    }

    private MvcResponse(String respCode, String respMsg, Object data) {
        this(respCode, respMsg);
        this.body = data;
    }



    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Head {
        /**
         * 返回码
         */
        private String rd;
        /**
         * 返回消息
         */
        private String rm;
    }

}
