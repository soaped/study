package com.yangfuzhao.common.json.JsonSerializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ipaynow.npacc.common.date.DateUtil;

import java.io.IOException;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: benyamin
 * Date: 17-3-2
 * Time: 下午5:54
 * To change this template use File | Settings | File Templates.
 */
public class JsonDateTimeSerializer extends JsonSerializer<Date> {
    @Override
    public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        if(value!=null) {
            jgen.writeString(DateUtil.getDateString(value, DateUtil.DATE_FORMAT_FULL));
        }
    }
}
