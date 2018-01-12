package com.xyls.common.random;

import java.util.Date;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: ipaynow0713
 * Date: 16-8-16
 * Time: 下午6:10
 * To change this template use File | Settings | File Templates.
 */
public class SeriaNumberUtil {

    /**
     * 时间戳加 UUID
     * @return
     */
    public static String getSerialNumberByTimeUUID(int length){
        StringBuffer stringBuffer = new StringBuffer(01);
        Date date = new Date();
        stringBuffer.append(date.getTime());
        UUID uuid = UUID.randomUUID();
        Long uuidL = uuid.getMostSignificantBits();
        stringBuffer.append(uuidL>0?uuidL:(uuidL*-1));
        return stringBuffer.substring(0,length - 1).toString();
    }
}
