package com.yangfuzhao.common.http_client;

import com.ipaynow.npacc.common.date.DateUtil;
import com.ipaynow.npacc.common.random.RandomUtil;
import com.ipaynow.npacc.common.secret.SecretUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

/**
 * Created by ipaynow1130 on 2017/10/9.
 */
public class Payment {




    public static void main(String [] args) throws UnsupportedEncodingException {
        HttpTookit httpTookit = new HttpTookit();

        String mhtOrderNo = RandomUtil.getRandomStr(13);

        //公众号支付,302到微信调起的地址
//        String appId = "150753094138037";
//        String appKey = "n0bloMQxHYDfwnqlF6poU6P6i9mXzdWB";
//        String deviceType = "0600";
//        String channelAuthCode = "";
//        String consumerCreateIp = "";
//        String payChannelType = "12";  //13微信 12支付宝 25手Q

        //主扫,返回二维码图片
//        String appId = "150753086263684";
//        String appKey = "zHGKLmQaU9PLMEGObyubsV5uhDAeYVqQ";
//        String deviceType = "08";
//        String channelAuthCode = "";
//        String consumerCreateIp = "";
//        String payChannelType = "12";  //13微信 12支付宝 25手Q

        //被扫,传支付码直接调起
        String appId = "150753082825470";
        String appKey = "8jTST7ywIBY0QQ3RlcxWEl08Xj9gaYyQ";
        String deviceType = "05";
        String channelAuthCode = "288909775327958429";
        String consumerCreateIp = "";
        String payChannelType = "12";  //13微信 12支付宝 25手Q

        //h5网页 ,   h5和app都需要去微信官方再做一次审核
//        String appId = "150753101889225";
//        String appKey = "HK9N7KA6MLKtxoRxRcfJ1GsdvAGjNyZw";
//        String deviceType = "0601";
//        String channelAuthCode = "";
//        String consumerCreateIp = "60.253.242.122";
//        String payChannelType = "13";  //13微信 12支付宝 25手Q


        Map<String,String> map = new HashMap<>();
        if(StringUtils.isNotEmpty(channelAuthCode)){
            map.put("channelAuthCode",channelAuthCode);
        }
        if(StringUtils.isNotEmpty(consumerCreateIp)) {
            map.put("consumerCreateIp", consumerCreateIp);
        }

        map.put("funcode","WP001");
        map.put("version","1.0.0");
        map.put("mhtCurrencyType","156");//人民币
        map.put("mhtOrderType","01");//交易类型-普通消费
        map.put("mhtOrderTimeOut","2000");//订单超时时间
        map.put("mhtCharset","UTF-8");
        map.put("mhtSignType","MD5");

        map.put("appId",appId);
        map.put("mhtOrderNo", mhtOrderNo);//订单号
        map.put("mhtOrderName","商品名称");
        map.put("mhtOrderAmt","1");//金额
        map.put("mhtOrderDetail","商品详情");


        map.put("mhtOrderStartTime",DateUtil.getCurDateTimeFormat(DateUtil.DATE_FORMAT_COMPACTFULL));//订单开始时间
        map.put("notifyUrl","http://posp.ipaynow.cn:10808/mobilewapH/notify");
        map.put("frontNotifyUrl","http://posp.ipaynow.cn:10808/mobilewapH/frontnotify");
        map.put("deviceType",deviceType);
        map.put("mhtLimitPay","0");//no_credit,不能使用信用卡
        map.put("payChannelType",payChannelType);
        map.put("outputType","0");

        String sign = SecretUtil.ToMd5(postFormLinkReport(map) +"&" + SecretUtil.ToMd5(appKey,"UTF-8",null),"UTF-8",null);
        map.put("mhtSignature",sign);
        map.put("appKey",appKey);
        String result = httpTookit.doPostUrlEncodeForm("https://pay.ipaynow.cn/",map,"UTF-8");
        System.out.println(URLDecoder.decode(result,"UTF-8"));
    }




    public static String postFormLinkReport(Map dataMap) {
        StringBuilder reportBuilder = new StringBuilder();

        List<String> keyList = new ArrayList<String>(dataMap.keySet());
        Collections.sort(keyList);

        for (String key : keyList) {
            reportBuilder.append(key + "=" + dataMap.get(key) + "&");
        }

        reportBuilder.deleteCharAt(reportBuilder.lastIndexOf("&"));

        return reportBuilder.toString();
    }




}
